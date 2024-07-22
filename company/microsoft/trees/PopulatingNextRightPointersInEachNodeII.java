package company.microsoft.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connectUsingLevelOrder(Node root) {
        if ( root == null ) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty()){
            int size = queue.size();
            for ( int i=0; i<size; i++){
                Node node = queue.poll();

                // Important check
                if ( i < size-1 ) {
                    node.next = queue.peek();
                }
                if ( node.left != null) queue.offer(node.left);
                if ( node.right != null ) queue.offer(node.right);
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };


    public Node connect(Node root) {
        Node dummy = new Node(0);
        Node prev = dummy;
        Node res = root;
        while ( root != null ){
            if ( root.left != null ){
                prev.next = root.left;
                prev = prev.next;
            }
            if ( root.right != null ){
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
            if ( root == null ){
                prev = dummy; // resets to beginning
                root = dummy.next; // root comes down
                dummy.next = null; // defaults to null
            }
        }
        return res;
    }
}
