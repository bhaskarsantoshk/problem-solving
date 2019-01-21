package LeetCode.TopInterviewQuestions;

public class P2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        int carry = 0;
        int sum =0;
        while (l1!=null || l2!=null || carry!=0) {
            sum = 0;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum+=carry;
            carry = sum/10;
            sum= sum%10;
            temp.next = new ListNode(sum);
            temp = temp.next;
        }
        return l3.next;
    }

    //  Definition for singly-linked list.
      static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


}
