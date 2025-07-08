package takeUForward.linkedlists.revision.singly_linked_list;

public class P3DeletionOfTheTailOfLL {
    public ListNode deleteTail(ListNode head) {
        if ( head == null || head.next == null) return null;
        ListNode cur = head;
        while ( cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}
