package company.microsoft.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    // Store original and copy Nodes mapping
    // T = O(N), S= O(N)
    public Node copyRandomListUsingHashMap(Node head) {
        if ( head == null  ) return head;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while ( cur != null ){
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while ( cur != null ){
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // First create copy nodes in between original nodes
    // Connect random nodes
    // Connect next nodes
    public Node copyRandomList(Node head) {
        Node cur = head;
        // Insert copy nodes in between
        while ( cur != null ){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        // Connect random nodes
        cur = head;
        while ( cur != null ){
            Node copy = cur.next;
            if (cur.random != null ) {
                copy.random = cur.random.next;
            }
            cur = cur.next.next;
        }

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
