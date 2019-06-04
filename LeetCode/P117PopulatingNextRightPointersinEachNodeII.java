package LeetCode;

public class P117PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        Node tempChild = new Node(0, null, null, null);
        Node result = root;
        while ( root != null ){
            Node currentChild = tempChild;
            while (root != null ){
                if (root.left != null ){
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if(root.right != null ){
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
            tempChild.next = null;
        }

        return result;

    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
