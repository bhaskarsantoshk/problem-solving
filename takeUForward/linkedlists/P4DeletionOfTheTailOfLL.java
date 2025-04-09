package takeUForward.linkedlists;

import striver_sde_sheet.ListNode;

public class P4DeletionOfTheTailOfLL {
    public ListNode deleteTail(ListNode head) {
        if ( head == null || head.next == null) return null;
        ListNode cur = head;
        while ( cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}
