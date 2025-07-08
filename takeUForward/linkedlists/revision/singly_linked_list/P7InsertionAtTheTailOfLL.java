package takeUForward.linkedlists.revision;

public class P7InsertionAtTheTailOfLL {
    public ListNode insertAtTail(ListNode head, int X) {
        if ( head == null) return new ListNode(X);
        if(head.next == null) {
            ListNode tail = new ListNode(X);
            head.next = tail;
            return head;
        }
        ListNode cur = head;
        while ( cur.next != null){
            cur = cur.next;
        }
        cur.next = new ListNode(X);
        return head;
    }
}
