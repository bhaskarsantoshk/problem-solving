package takeUForward.linkedlists.revision2;

public class P3DeletionOfTheHeadOfLL {
    public ListNode deleteHead(ListNode head) {
        if ( head == null) return null;
        return head.next;
    }
}
