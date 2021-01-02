package Leetcode.explore.recursion;

public class  ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode secondNode = head.next;
        head.next = null;
        ListNode reverseRest = reverseList(secondNode);
        secondNode.next = head;
        return reverseRest;
    }
}

/*

What is the reverse of null (the empty list)? null.
What is the reverse of a one element list? the element.
What is the reverse of an n element list? the reverse of the rest of the list followed by the first element.

https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/2378/

*/