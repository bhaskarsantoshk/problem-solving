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
}
