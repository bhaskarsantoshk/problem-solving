package company.google;

import company.microsoft.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEndBruteForce(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while ( cur != null ){
            len++;
            cur = cur.next;
        }

        // positionToRemove
        int positionToRemove = len -n;
        if ( positionToRemove == 0 ) return head.next;
        if ( positionToRemove < 0 ) return null;
        cur = head;
        for ( int i=0; i<positionToRemove-1; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        for ( int i=0; i<n; i++){
            fast = fast.next;
        }
        if ( fast == null ) return head.next;
        while ( fast.next != null ){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args){
        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = obj.removeNthFromEndBruteForce(head, 2);
        ListNode cur = res;
        while ( cur != null ){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
