package LeetCode;

public class P160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0, lenB=0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != null){
            lenA++;
            cur1 = cur1.next;
        }
        while(cur2 != null){
            lenB++;
            cur2 = cur2.next;
        }
        int diff = Math.abs(lenA - lenB);
        if(lenA < lenB){
            return intersection(headB, headA, diff);
        }
        else{
            return intersection(headA, headB, diff);
        }
    }

    private ListNode intersection(ListNode headA, ListNode headB, int diff) {
        while(diff != 0){
            headA= headA.next;
            diff--;
        }

        while(headA != headB){
            headA= headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNodeOnePass(ListNode headA, ListNode headB){
        if(headA == null  || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a!= b){
            a = a== null ? headB : a.next;
            b = b== null ? headA : b.next;
        }
        return a;
    }
}
