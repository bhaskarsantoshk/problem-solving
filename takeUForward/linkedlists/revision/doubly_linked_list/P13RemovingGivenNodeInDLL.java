package takeUForward.linkedlists.revision.doubly_linked_list;

public class P13RemovingGivenNodeInDLL {
    public void deleteGivenNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        if ( next == null) {
            prev.next = null;
            node.prev = null;
            return;
        }
        prev.next = next;
        next.prev = prev;
        node.next = node.prev = null;
    }
}
