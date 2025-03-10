package takeUForward.blind75.linkedlists;

import company.microsoft.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null || n == 0) return head;
        ListNode slow = head;
        ListNode fast = head;

        for ( int i=0; i<n; i++){
            fast = fast.next;
            if ( fast == null) break;
        }
        if ( fast == null) return head.next;

        while ( fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
