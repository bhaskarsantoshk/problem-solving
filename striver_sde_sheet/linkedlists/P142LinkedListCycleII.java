package striver_sde_sheet.linkedlists;
import company.microsoft.ListNode;

public class P142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if ( head == null || head.next == null ) return null;

        ListNode slow = head;
        ListNode fast = head;

        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) break;
        }
        if ( fast == null || fast.next == null ) return null; // important check when there is no loop
        slow = head;
        while ( slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
