package takeUForward.linkedlists.revision.doubly_linked_list;

public class P11DeleteTailOfDLL {
    public ListNode deleteTail(ListNode head) {
        if ( head == null || head.next == null) return null;
        ListNode tail = head;
        while ( tail.next != null){
            tail = tail.next;
        }
        ListNode newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }
}
