package takeUForward.linkedlists.revision.doubly_linked_list;

public class P10DeleteHeadOfDLL {
    public ListNode deleteHead(ListNode head) {
        if ( head == null) return null;
        ListNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }
}
