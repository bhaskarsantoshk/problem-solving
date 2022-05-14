package express_prep.amzn.top_voted;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;
        while ( l1 != null || l2 != null){
            int sum = ( l1 != null ? l1.val : 0) + ( l2 != null ? l2.val: 0) + carry;
            current.next = new ListNode(sum%10);
            carry = sum / 10;
            l1 = ( l1 != null ) ? l1.next: l1;
            l2 = ( l2 != null ) ? l2.next: l2;
            current = current.next;
        }
        if ( carry == 1){
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
}
