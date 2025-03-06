package company.microsoft.revision;

import company.microsoft.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p= dummy;
        int carry = 0;
        while ( l1 != null || l2 != null || carry != 0){
            if ( l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if ( l2!= null){
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry/=10;
            p = p.next;
        }
        return dummy.next;
    }
}
