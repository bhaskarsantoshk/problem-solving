package takeUForward.linkedlists.revision2;

public class P8DeleteHeadOfDoublyLinkedList {
    public ListNode deleteHead(ListNode head) {
        if ( head == null || head.next == null) return null;
        ListNode next = head.next;
        next.prev = null;
        head.next = null;
        return next;
    }

    public ListNode deleteHeadSecondVariant(ListNode head) {
        if ( head == null || head.next == null) return null;
        ListNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    class ListNode {
        public int data;
        public ListNode prev;
        public ListNode next;

        public ListNode() {

        }

        public ListNode(int data) {

        }

        public ListNode(int data, ListNode prev, ListNode next) {

        }
    };
}
