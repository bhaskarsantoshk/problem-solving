package takeUForward.linkedlists.revision.doubly_linked_list;

public class P14InsertNodeBeforeHeadInDLL {
    public ListNode insertBeforeHead(ListNode head, int X) {
        ListNode newHead = new ListNode(X, head, null);
        head.prev = newHead;
        return newHead;
    }
}
