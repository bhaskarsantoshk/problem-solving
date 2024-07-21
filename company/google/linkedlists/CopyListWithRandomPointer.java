package company.google.linkedlists;


public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // insert copy nodes in between
        Node cur = head;
        while ( cur != null ){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        // connect random Nodes
        cur = head;
        while ( cur != null ){
            Node copy = cur.next;
            if ( cur.random != null)
                copy.random = cur.random.next;
            cur = cur.next.next;
        }

        // connect next nodes
        cur = head;
        Node dummy = new Node(0);
        Node res = dummy;
        while ( cur != null ){
            res.next = cur.next;
            cur.next = cur.next.next;
            res = res.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    class Node {
        int val;
        Node next, random;

        Node ( int val){
            this.val = val;
            this.random = null;
            this.next = null;
        }
    }
}
