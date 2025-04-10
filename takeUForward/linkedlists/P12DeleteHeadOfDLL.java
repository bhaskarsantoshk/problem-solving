package takeUForward.linkedlists;

import takeUForward.linkedlists.doubly_linked_list.ListNode;

public class P12DeleteHeadOfDLL {
    public ListNode deleteHead(ListNode head) {
        if ( head == null) return null;
        if ( head.next == null) return null;
        ListNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }
}
