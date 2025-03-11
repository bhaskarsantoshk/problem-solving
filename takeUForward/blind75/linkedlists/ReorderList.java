package takeUForward.blind75.linkedlists;

import company.microsoft.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if ( head == null || head.next == null) return;

        // 1 2 3 4 5 6 7 8
        ListNode slow = head;
        ListNode fast = head;
        ListNode middle = head;
        while( fast != null && fast.next != null){
            middle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1 2 3 4(middle)

        middle.next = null; // fow now: 1 2 3 4, 5 6 7 8 - two lists
        ListNode l2 = reverse(slow);
        ListNode l1 = head;
        merge(l1, l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        while ( l1 != null ){
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            if ( next1 == null) break;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while ( cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
