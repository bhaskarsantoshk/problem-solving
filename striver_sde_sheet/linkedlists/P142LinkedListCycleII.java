package striver_sde_sheet.linkedlists;
import company.microsoft.ListNode;

public class P142LinkedListCycleII {

    // when slow enters the starting of cycle, it travelled L1,
    // and fast travelled 2 L1, which means they are L1 Apart
    // Let's assume the distance between them in fast and slow within the loop direction is d
    // now if they meet at some point -> which means they travelled d distance
    // because fast travelled 2 steps and slow travelled one step
    // overall cycle length is L1+d so the starting point will be at L1 from point of collision
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
