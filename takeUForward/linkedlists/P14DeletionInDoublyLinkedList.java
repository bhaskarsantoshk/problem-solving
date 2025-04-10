package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P14DeletionInDoublyLinkedList {
    static Node deleteNode(Node head, int pos) {
        if ( head == null || head.next == null) return head;
        if ( pos == 0){
            head = head.next;
            head.prev = null;
            return head;
        }
        Node cur = head;
        int count = 0;
        while ( cur != null && count < pos ){
            count++;
            cur = cur.next;
        }
        // If pos is out of bounds
        if (cur == null) return head;
        Node prev = cur.prev;
        Node next = cur.next;
        cur.prev = null;
        prev.next = next;
        cur.next = null;
        return head;
    }
}
