package company.amazon.leetcode;

public class P116PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
            if ( root == null ) return null;
            connectNode(root);
            return root;
    }

    private void connectNode(Node root) {
        if ( root == null ) return;
        Node start = root;
        while ( start != null ){
            Node cur = start;
            while ( cur!= null){
                if ( cur.left != null ){
                    cur.left.next = cur.right;
                }
                if ( cur.right != null && cur.next != null ){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}
