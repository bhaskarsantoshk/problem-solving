package takeUForward.linkedlists.revision.singly_linked_list;

public class P9InsertionBeforeTheValueXInLL {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        if ( head == null) return null;
        if ( head.val == X) return new ListNode(val, head);
        ListNode cur = head;
        while ( cur.next != null){
            if ( cur.next.val == X){
                cur.next = new ListNode(val, cur.next);
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
