package takeUForward.linkedlists.revision2;

public class P7InsertNodeBeforeHeadInDoublyLinkedList {
    public ListNode insertBeforeHead(ListNode head, int data) {
        ListNode newHead = new ListNode(data, null, head);
        if ( head != null ) head.prev = newHead;
        return newHead;
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
