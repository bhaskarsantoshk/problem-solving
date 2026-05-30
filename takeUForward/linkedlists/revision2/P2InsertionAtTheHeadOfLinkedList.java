package takeUForward.linkedlists.revision2;

public class P2InsertionAtTheHeadOfLinkedList {
    public ListNode insertAtHead(ListNode head, int X) {
        if ( head == null) return new ListNode(X);
        ListNode cur = new ListNode(X, head);
        return cur;
    }
}
