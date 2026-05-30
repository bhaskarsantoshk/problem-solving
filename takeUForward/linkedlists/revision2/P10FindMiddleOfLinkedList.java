package takeUForward.linkedlists.revision2;

public class P10FindMiddleOfLinkedList {
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while ( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
