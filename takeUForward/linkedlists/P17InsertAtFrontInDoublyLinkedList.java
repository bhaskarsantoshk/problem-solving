package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P17InsertAtFrontInDoublyLinkedList {
    public Node insertAtFrontoFtheDoublyLinkedList( Node head, int val){
        Node newH = new Node(val);
        newH.next = head;
        if( head != null ) head.prev = newH;
        return newH;
    }
}
