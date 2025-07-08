package takeUForward.linkedlists.revision.singly_linked_list;

public class P6InsertionAtTheHeadOfLL {
    public ListNode insertAtHead(ListNode head, int X) {
        if ( head == null) return new ListNode(X);
        ListNode cur = new ListNode(X, head);
        return cur;
    }
}
