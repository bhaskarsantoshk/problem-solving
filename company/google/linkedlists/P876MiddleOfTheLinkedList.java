package company.google.linkedlists;

import company.microsoft.ListNode;

public class P876MiddleOfTheLinkedList {

    // Bruteforce ->
    // count the number of nodes
    // devided by 2 , if even, mid = len/2 or len/2 +1 ( check with interviewer) , if odd, mid = len/2 + 1
    // go to the mid in 2nd iteration

    // Optimized - slow fast pointer

    public ListNode middleNode(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode slow = head;
        ListNode fast = head;

        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }
}
