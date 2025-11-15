package takeUForward.QR;

public class P22SortALLOf0S1SAnd2S {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);
        ListNode z = zeroDummy;
        ListNode o = oneDummy;
        ListNode t = twoDummy;
        ListNode cur = head;
        while ( cur != null){
            if ( cur.val == 0){
                z.next = cur;
                z = z.next;
            } else if ( cur.val == 1){
                o.next = cur;
                o = o.next;
            } else {
                t.next = cur;
                t = t.next;
            }
            cur = cur.next;
        }
        t.next = null;
        z.next = oneDummy.next != null ? oneDummy.next : twoDummy.next;
        o.next = twoDummy.next;
        if ( zeroDummy.next != null) return zeroDummy.next;
        if ( oneDummy.next != null) return oneDummy.next;

        return twoDummy.next;
    }

}
