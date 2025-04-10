package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P16DeleteAGivenNode {
    public static void deleteNode(Node cur) {
        if ( cur == null) return;
        Node prev = cur.prev;
        Node next = cur.next;
        if (next == null){
            prev.next = null;
            cur.prev = null;
            return;
        }
        prev.next = next;
        next.prev = prev;
        cur.next = cur.prev = null;
    }
}
