package company.microsoft;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;;
            if ( slow == fast ) {
                slow = a;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
