package takeUForward.linkedlists.revision.singly_linked_list;

public class P2DeletionOfTheHeadOfLL {
    public ListNode deleteHead(ListNode head) {
        if ( head == null) return null;
        return head.next;
    }
}
