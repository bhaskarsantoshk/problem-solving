package Leetcode.explore.recursion;

public class  SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}

/*

URL: https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1681/

*/

