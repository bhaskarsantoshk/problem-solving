package takeUForward.linkedlists;
import takeUForward.linkedlists.doubly_linked_list.Node;

public class P11ConstructDLL {
    public static Node constructDLL(int []arr) {
        if ( arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node cur = head;
        for ( int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            newNode.prev = cur;
            cur.next = newNode;
            cur = cur.next;
        }
        return head;
    }
}
