package takeUForward.linkedlists.revision.singly_linked_list;

public class P8InsertionAtTheKthPositionOfLL {
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if ( head == null){
            if ( K == 1) return new ListNode(X);
            return null;
        }
        if ( K == 1) return new ListNode(X, head);
        ListNode cur = head;
        int count = 0;
        while ( cur.next != null){
            count++;
            if ( count == K-1) {
                cur.next = new ListNode(X, cur.next);
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
