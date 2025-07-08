package takeUForward.linkedlists.revision.singly_linked_list;

public class P5DeleteTheElementWithValueX {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if ( head == null) return null;
        if ( head.val == X) {
            ListNode result = head.next;
            head = null;
            return result;
            // simply return head.next works too
        }
        ListNode cur = head, prev = null;
        while ( cur != null){
            if ( cur.val == X){
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
