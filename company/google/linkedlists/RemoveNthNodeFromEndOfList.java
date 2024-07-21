package company.google.linkedlists;

import company.microsoft.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for ( int i=0; i<n; i++){
            if ( fast == null ) break;
            fast = fast.next;
        }
        if ( fast == null ) return head.next;
        while ( fast.next != null ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
