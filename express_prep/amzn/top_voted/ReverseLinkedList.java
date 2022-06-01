package express_prep.amzn.top_voted;

public class ReverseLinkedList {
    public ListNode reverseListRec(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode reverseRest = reverseListRec(next);
        next.next = head;
        return reverseRest;
    }


    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) return head;
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
