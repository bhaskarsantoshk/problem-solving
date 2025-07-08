package takeUForward.linkedlists.revision;

public class P2DeletionOfTheHeadOfLL {
    public ListNode deleteHead(ListNode head) {
        if ( head == null) return null;
        return head.next;
    }
}
