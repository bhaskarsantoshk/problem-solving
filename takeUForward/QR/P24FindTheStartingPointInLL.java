package takeUForward.QR;

public class P24FindTheStartingPointInLL {
    public ListNode findStartingPoint(ListNode head) {
        if ( head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while ( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if ( slow == fast){
                slow = head;
                while ( slow != fast){
                    slow = slow.next;
                    fast = fast.next;

                }
                return slow;
            }
        }
        return null;
    }
}
