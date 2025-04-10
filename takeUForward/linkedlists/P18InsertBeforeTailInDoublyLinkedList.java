package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P18InsertBeforeTailInDoublyLinkedList {
    public Node insertBeforeTailInDoublyLinkedList( Node head, int val){
        if ( head == null) return null;
        if ( head.next == null){
            Node newH = new Node(val);
            newH.next = head;
            head.prev = newH;
            return newH;
        }
        Node tail = head;
        while ( tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = prev;
        prev.next = newNode;
        tail.prev = newNode;
        return head;
    }
}
