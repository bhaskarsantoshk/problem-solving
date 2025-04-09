package takeUForward.linkedlists;

public class P8InsertAtEnd {
    public static Node insertEnd(Node head, int k) {
        if ( head == null) {
            head = new Node(k);
            return head;
        }
        Node cur = head;
        while ( cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node(k);
        return head;
    }
}
