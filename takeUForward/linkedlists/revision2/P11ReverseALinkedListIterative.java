package takeUForward.linkedlists.revision2;

public class P11ReverseALinkedListIterative {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
            val = 0;
            next = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
        }

        ListNode(int data1, ListNode next1) {
            val = data1;
            next = next1;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while ( cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if ( head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
}
