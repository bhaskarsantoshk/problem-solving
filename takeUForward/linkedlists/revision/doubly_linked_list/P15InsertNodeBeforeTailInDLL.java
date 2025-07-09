package takeUForward.linkedlists.revision.doubly_linked_list;

public class P15InsertNodeBeforeTailInDLL {
    public ListNode insertBeforeTail(ListNode head, int X) {
        if ( head == null) return new ListNode(X);
        if ( head.next == null) return insertBeforeHead(head, X);
        ListNode tail = head;
        while ( tail.next != null){
            tail = tail.next;
        }
        ListNode prev = tail.prev;
        ListNode newNode = new ListNode(X, tail, prev);
        tail.prev = newNode;
        prev.next = newNode;
        return head;
    }

    private ListNode insertBeforeHead(ListNode head, int x) {
        ListNode newNode = new ListNode(x, head, null);
        if ( head != null) head.prev = newNode;
        return newNode;
    }
}
