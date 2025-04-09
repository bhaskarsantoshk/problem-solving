package takeUForward.linkedlists;

import striver_sde_sheet.ListNode;

public class P7InsertAtHead {
    public ListNode insertAtHead(ListNode head, int val){
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        return newHead;
    }
}
