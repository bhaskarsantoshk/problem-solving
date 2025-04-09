package takeUForward.linkedlists;

public class P6DeleteNodeWithValueX {
    public static Node deleteNode(Node head, int x) {
        if ( head == null) return head;
        Node cur = head;
        if (head.data == x) {
            return head.next;
        }
        Node prev = null;
        while ( cur != null){
           if ( cur.data == x){
               prev.next = cur.next;
               break;
           }
           prev = cur;
           cur = cur.next;
        }
        return head;
    }
}
