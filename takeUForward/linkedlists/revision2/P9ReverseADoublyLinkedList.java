package takeUForward.linkedlists.revision2;

public class P9ReverseADoublyLinkedList {
    class ListNode {
        int data;
        ListNode prev, next;
        ListNode(int val) {
            this.data = val;
            this.prev = null;
            this.next = null;
        }
    }

    public ListNode reverseDLL(ListNode head) {
        if ( head == null) return null;
        ListNode next = head.next;
        head.next = head.prev;
        head.prev = next;
        if ( head.prev == null) return head;
        return reverseDLL(next);
    }
}
