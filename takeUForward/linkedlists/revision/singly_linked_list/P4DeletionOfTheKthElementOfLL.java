package takeUForward.linkedlists.revision;

public class P4DeletionOfTheKthElementOfLL {
    public ListNode deleteKthNode(ListNode head, int k) {
        if ( head == null) return null;
        if ( k == 1) return head.next;
        ListNode prev = null, cur = head;
        int count = 0;
        while ( cur != null){
            count++;
            if ( count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
