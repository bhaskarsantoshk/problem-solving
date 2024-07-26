package striver_sde_sheet.linkedlists;

import company.microsoft.ListNode;

public class P141LinkedListCycle {

    //Bruteforce is store the nodes in a set and iterate over to see if you see a duplicate

    // Optimal - O(N) Time and O(1) space
    public boolean hasCycle(ListNode head) {
        if ( head == null || head.next == null ) return false;
        ListNode slow = head;
        ListNode fast = head;
        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) return true;
        }
        return false;
    }
}
