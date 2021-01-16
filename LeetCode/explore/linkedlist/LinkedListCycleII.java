package LeetCode.explore.linkedlist;

import LeetCode.explore.recursion.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while ( fast != null && fast.next != null ){
                slow = slow.next;
                fast = fast.next.next;

                if ( slow == fast ){
                    ListNode slow1 = head;
                    while ( slow1 != slow ){
                        slow = slow.next;
                        slow1 = slow1.next;
                    } 
                    return slow;
                }
            }
            return null;
    }
}