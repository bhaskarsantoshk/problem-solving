package takeUForward.linkedlists;

public class P9InsertAtPositionK {
    static Node insert(Node head, int n, int pos, int val) {
        if ( head == null){
            if ( pos == 1) return new Node(val);
            else return null;
        }
        if ( pos == 0){
            Node newHead = new Node(val);
            newHead.next= head;
            return newHead;
        }
        int count =0;
        Node cur = head;
        while ( cur != null){
            count++;
            if ( count == pos){
                Node newNode = new Node(val);
                newNode.next = cur.next;
                cur.next = newNode;
                return head;
            }
            cur = cur.next;
        }
        return head;

    }
}
