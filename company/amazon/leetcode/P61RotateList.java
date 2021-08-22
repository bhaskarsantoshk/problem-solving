package company.amazon.leetcode;

public class P61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null || head.next == null || k <= 0) return head;
        // if k <0, we might need to rotate left, that's a new problem

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode fast = res, slow = res;

        int len;
        for( len = 0; fast.next != null ; len++){
            fast = fast.next;
        }
        for ( int j= len- k%len; j>0; j-- ){
            slow= slow.next;
        }
        fast.next = res.next; // rotation
        res.next = slow.next;
        slow.next = null;
        return res.next;
    }
}
