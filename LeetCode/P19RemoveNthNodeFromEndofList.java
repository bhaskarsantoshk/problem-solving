package LeetCode;

public class P19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode tempHead = new ListNode(0);
        for(int i=1; i<= n; i++){
            fast = fast.next;
        }
        ListNode slow = tempHead;
        slow.next = head;
        while ( fast != null ){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tempHead.next;
    }
}
