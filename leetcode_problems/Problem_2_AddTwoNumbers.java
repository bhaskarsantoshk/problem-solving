package leetcode_problems;

public class Problem_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head = new ListNode(0);
       ListNode res = head;
       int carry = 0;
       while ( l1 != null || l2 != null ){
           int sum = (l1 != null ? l1.val : 0) + ( l2 != null ? l2.val : 0) + carry;
           res.next = new ListNode(sum%10);
           carry = sum/10;
           l1 = ( l1 != null ? l1.next : l1);
           l2 = ( l2 != null ? l2.next : l2);
           res = res.next;
       }
        if ( carry == 1){
            res.next = new ListNode(1);
        }
       return head.next;
    }
}
