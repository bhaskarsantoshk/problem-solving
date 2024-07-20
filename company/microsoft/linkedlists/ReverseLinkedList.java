package company.microsoft.linkedlists;

import company.microsoft.ListNode;

public class ReverseLinkedList {

    // Bruteforce
    // traverse through LL, put elements in stack
    // iterate LL again , pop each element from stack and update the cur node value
    // return head
    // T = o(n) , S = O(n)

    // Optimized
    // The only way is to switch the links
    // If we have prev node, we can point cur node to prev
    // at the same time we need to store the next else we will lose track
    // then move cur to next
    // repeat it
    // T = O(n) S = O(1)
    public ListNode reverseList(ListNode head) {
        if ( head == null ) return head;
        ListNode prev = null;
        ListNode cur = head;
        while ( cur != null ){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // Recursive
    // 1 2 3 4 5
    // reaches 5 -> return 5 to previous func call
    // head here is 4
    // next = 5
    // 5 -> 4 returns 5 to prev func call with 3
    // head here is 3
    // next = 4
    // 5 -> 4 -> 3 etc.
    public ListNode reverseListRec(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode newHead =  reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }
}
