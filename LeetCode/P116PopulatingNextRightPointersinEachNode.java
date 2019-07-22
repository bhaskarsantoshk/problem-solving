package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P116PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        Node node = root;
        connectNodes(node);
        return root;
    }

    private void connectNodes(Node root) {
        if ( root == null ) return;
        Node levelStart = root;
        while ( levelStart != null ){
            Node cur = levelStart;
            while ( cur!= null ){
                if ( cur.left != null ){
                    cur.left.next = cur.right;
                }
                if ( cur.right != null && cur.next != null ){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }

    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}


