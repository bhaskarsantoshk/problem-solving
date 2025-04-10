package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P13DeleteLastNodeOfADoublyLinkedList {
    public static Node deleteLastNode(Node head) {
        if ( head == null) return null;
        if ( head.next == null) {
            return null;
        }
        Node cur = head;
        while ( cur.next != null){
            cur = cur.next;
        }
        Node prev = cur.prev;
        cur.prev = null;
        prev.next = null;
        return head;
    }
}
