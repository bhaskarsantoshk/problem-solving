package takeUForward.linkedlists.revision.doubly_linked_list;

public class P12DeleteKthElementOfDLL {
    public ListNode deleteKthElement(ListNode head, int k) {
        if ( head == null) return null;
        int count = 0;
        ListNode cur = head;
        while ( cur != null){
            count++;
            if ( count == k) break;
            cur = cur.next;
        }
        ListNode prev = cur.prev;
        ListNode next = cur.next;
        if ( prev == null && next == null) return null;
        if ( prev == null) return deleteHead(head);
        if ( next == null) return deleteTail(head);
        prev.next = next;
        next.prev = prev;
        cur.next = cur.prev = null;
        return head;
    }

    private ListNode deleteTail(ListNode head) {
        if ( head == null || head.next == null) return null;
        ListNode tail = head;
        while ( tail.next != null){
            tail = tail.next;
        }
        ListNode prev = tail.prev;
        prev.next = null;
        tail.prev = null;
        return head;
    }

    private ListNode deleteHead(ListNode head) {
        if ( head == null || head.next == null) return null;
        head = head.next;
        head.prev = null;
        return head;
    }
}
