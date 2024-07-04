package company.microsoft;

import company.microsoft.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode p = dummy;
        int carry = 0;
        while ( l1 != null || l2 != null || carry != 0 ){
            if ( l1 != null ) {
                carry += l1.val;
                l1 = l1.next;
            }
            if ( l2 != null ) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(0);
            p.next.val = carry%10;
            carry/=10;
            p = p.next;
        }
        return dummy.next;
    }
}
