package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P19InsertAtLastInDoublyLinkedList {
    public static Node insertAtTail(Node head, int val) {
        if ( head == null) return new Node(val);
        if ( head.next == null){
            head.next = new Node(val);
            head.next.prev = head;
            return head;
        }

        Node cur = head;
        while ( cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node(val);
        cur.next.prev = cur;
        return head;
    }
}
