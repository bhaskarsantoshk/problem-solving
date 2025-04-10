package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P15DeleteAGivenNodeWithValueX {
    public static Node deleteNode(Node head, int x) {
        if ( head == null) return null;
        if ( head.data == x) {
            Node newHead = head.next;
            newHead.prev = null;
            head.prev = null;
            head.next = null;
            return newHead;
        }
        Node cur = head;
        while ( cur != null && cur.data != x ){
            cur = cur.next;
        }
        if ( cur == null) return head;
        Node prev = cur.prev;
        Node next = cur.next;
        if ( prev != null ) prev.next = next;
        if ( next != null) next.prev = prev;
        cur.next = cur.prev = null;
        return head;
    }
}
