package company.google;

import company.microsoft.ListNode;

public class P237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if ( node == null ) return;
        if ( node.next == null ) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode deleteFirst(ListNode head){
        if ( head == null || head.next == null ) return null;
        ListNode temp = head;
        head = head.next;
        return head;
    }

    public ListNode deleteLast(ListNode head){
        if ( head == null || head.next == null ) return null;
        ListNode temp = head;
        while ( temp.next.next != null ){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public ListNode deleteKthNode ( ListNode head, int k ){
        if ( head == null ) return head;
        if ( k == 1) {
            head = null;
            return head;
        }
        ListNode cur = head, prev = null;
        int count = 0;
        while ( cur != null ){
            count++;
            if ( count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
