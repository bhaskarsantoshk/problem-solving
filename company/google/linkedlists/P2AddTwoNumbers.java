package company.google.linkedlists;

import company.microsoft.ListNode;

public class P2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        int sum = 0;
        while ( l1 != null || l2 != null || carry != 0){
            sum = 0;
            if ( l1 != null ){
                sum += l1.val;
                l1 = l1.next;
            }
            if ( l2 != null ){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            cur.next = new ListNode(sum%10);
            carry = sum/10;
            cur = cur.next;
        }
        return dummy.next;
    }
}
