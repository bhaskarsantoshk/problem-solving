package company.microsoft.trees;

import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
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

    // move to next level only after establishing connections
    // connection 1 -> easy -> node.left.next = node.right
    // connection 2 -> not straight forward -> node.right.next = node.next.left ( picture this using a binary tree with 3 levels )
    public Node connect(Node root) {
        if ( root == null ) return root;
        Node leftMost = root;
        while ( leftMost.left != null ){
            Node head = leftMost;
            while ( head != null ){
                //conn 1
                head.left.next = head.right;
                if ( head.next != null ){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }


    // Recursive

    public Node connectRec(Node root) {
        if ( root == null || root.left == null ) return root;
        root.left.next = root.right;
        // if it's perfectly balanced binary tree, no need to check right null or not
        if (root.next != null ) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
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
}
