package takeUForward.QR;

public class P23CheckIfLLIsPalindromeOrNot {
    public boolean isPalindrome(ListNode head) {
        if ( head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode cur1 = head;
        ListNode cur2 = newHead;
        while ( cur2 != null){
            if ( cur1.val != cur2.val) return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        slow.next = reverse(newHead);
        return true;
    }

    private ListNode reverse(ListNode head) {
        if ( head == null || head.next == null) return head;
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;
        while ( cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
