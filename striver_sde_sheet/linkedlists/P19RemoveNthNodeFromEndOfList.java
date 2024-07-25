package striver_sde_sheet.linkedlists;

import company.microsoft.ListNode;

public class P19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        if ( head == null ) return null;
        int count = 1;
        ListNode cur = head;
        while ( cur.next != null ){
            count++;
            cur = cur.next;
        }

        if ( count == n){
            return head.next;
        } else if ( count < n) return null;
        else {
            int diff = count - n;
            cur = head;
            while ( cur != null ){
                diff--;
                if ( diff == 0) break;
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for ( int i=0; i<n; i++){
            fast = fast.next;
            if ( fast == null ) break;
        }
        if ( fast == null ) return head.next;

        while ( fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
