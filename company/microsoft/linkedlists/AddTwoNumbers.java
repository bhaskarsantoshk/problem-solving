/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while ( A != null || B != null || carry != 0){
            if ( A != null ){
                carry += A.val;
                A = A.next;
            }
            if ( B != null ){
                carry += B.val;
                B = B.next;
            }
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;
        }
        return dummy.next;
    }
}
