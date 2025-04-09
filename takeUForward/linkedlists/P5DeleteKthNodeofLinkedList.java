package takeUForward.linkedlists;

import striver_sde_sheet.ListNode;

public class P5DeleteKthNodeofLinkedList {
    static ListNode deleteKthNodeFromLinkedList(ListNode head, int k){
        if ( head == null) return head;
        ListNode cur = head;
        ListNode prev = null;
        int count = 0;
        while ( cur != null){
            count++;
            if ( count == k){
                prev.next = prev.next.next;
            }
        }
        return head;
    }
}
