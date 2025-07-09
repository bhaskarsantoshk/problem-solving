package takeUForward.linkedlists.revision.doubly_linked_list;

public class P17InsertBeforeGivenNodeInDLL {
    public void insertBeforeGivenNode(ListNode node, int X) {
        if ( node == null) return;
        ListNode prev = node.prev;
        ListNode newNode = new ListNode(X, node, prev);
        prev.next = newNode;
        node.prev = newNode;
    }
}
