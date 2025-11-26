package takeUForward.QR;

public class P43LargestBSTInBinaryTree {
    public int largestBST(TreeNode root) {
     return helper(root).size;
    }

    private Node helper(TreeNode root) {
        if ( root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Node left = helper(root.left);
        Node right = helper(root.right);
        if ( left.max < root.data && root.data < right.min ){
            return new Node(Math.min(left.min, root.data),
                    Math.max(right.max, root.data),
                    left.size+right.size+1);
        }
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    class Node {
        int min, max, size;

        public Node(int min, int max, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
}