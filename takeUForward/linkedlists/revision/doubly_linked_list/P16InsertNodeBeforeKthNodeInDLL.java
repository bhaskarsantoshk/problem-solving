package takeUForward.linkedlists.revision.doubly_linked_list;

public class P16InsertNodeBeforeKthNodeInDLL {
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        if ( K == 1) return insertBeforeHead(head, X);
        ListNode cur = head;
        int count = 0;
        while ( cur != null){
            count++;
            if ( count == K) break;
            cur = cur.next;
        }
        ListNode prev = cur.prev;
        ListNode newNode = new ListNode(X, cur, prev);
        prev.next = newNode;
        cur.prev = newNode;
        return head;
    }

    private ListNode insertBeforeHead(ListNode head, int x) {
        ListNode newNode = new ListNode(x, head, null);
        if ( head != null) head.prev = newNode;
        return newNode;
    }
}
