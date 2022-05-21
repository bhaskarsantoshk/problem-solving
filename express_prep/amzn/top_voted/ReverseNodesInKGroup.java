package express_prep.amzn.top_voted;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if ( head == null || head.next == null || k ==1 ) return head;
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy;
        dummy.next = head;
        int i = 0;
        while ( head != null ){
            i++;
            if ( i % k == 0){
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode cur = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = cur;
        while ( cur != end){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        begin.next = prev;
        first.next = cur    ;
        return first;
    }


    private ListNode reverseListRec (ListNode head){
        if ( head == null || head.next == null ) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode reverseRest = reverseListRec(next);
        next.next = head;
        return reverseRest;
    }


    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        ListNode cur = head;
        while ( cur != null ){
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

}


