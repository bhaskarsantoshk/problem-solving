package striver_sde_sheet.linkedlists;

import striver_sde_sheet.ListNode;

public class P26ReverseLinkedList {

    public ListNode reverseListStack(ListNode head) {
        if ( head == null || head.next == null) return head;
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

}
