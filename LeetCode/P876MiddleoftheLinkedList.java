package LeetCode;

public class P876MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if ( head == null ) return null;
        ListNode slow = head;
        ListNode fast = head;

        while ( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if ( fast.next != null ){
            slow = slow.next;
        }
        return slow;
    }
}
