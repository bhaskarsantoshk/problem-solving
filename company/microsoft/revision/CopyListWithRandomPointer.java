package company.microsoft.revision;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head){
        if ( head == null ) return head;

        // add copyNodes between nodes
        Node cur = head;
        while ( cur != null ){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        // connect random nodes
        cur = head;
        while ( cur != null ){
            Node copy = cur.next;
            if (cur.random != null ) {
                copy.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // connect next
        Node dummy = new Node(0);
        Node res = dummy;
        cur = head;

        while ( cur != null ){
            res.next = cur.next;
            cur.next = cur.next.next;
            res = res.next;
            cur = cur.next;
        }

        return dummy.next;

    }
    public Node copyRandomListHashMap(Node head) {
        if ( head == null ) return head;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while ( cur!= null ){
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while ( cur!= null ){
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
