package takeUForward.linkedlists;

public class P10InsertBeforeX {
    static Node insertBeforeX(Node head, int n, int x, int val) {
        if ( head == null ) return null;
        if ( head.data == x){
            Node newH = new Node(x);
            newH.next = head;
            return newH;
        }
        Node cur = head;
        while ( cur.next != null){
            if ( cur.next.data == x){
                Node newNode = new Node(val);
                newNode.next = cur.next;
                cur.next = newNode;
                break;
            }
        }
        return head;
    }
}
