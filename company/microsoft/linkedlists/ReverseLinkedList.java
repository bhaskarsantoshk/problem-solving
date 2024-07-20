package company.microsoft.linkedlists;

import company.microsoft.ListNode;

public class ReverseLinkedList {
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
}
