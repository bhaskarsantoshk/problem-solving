package company.microsoft;

public class LargestBSTInBinaryTree {

    // Bruteforce

    // validate BST at every node
    // if true : find the number of nodes in that tree
    // update max;
    int max = 0;
    public int largestBSTBruteForce(TreeNode root) {
        dfs ( root);
        return max;
    }

    private void dfs(TreeNode root) {
        if ( root == null) return;
        if ( validateBST(root)) max = Math.max(max, getNumOfNodes(root));
        dfs(root.left);
        dfs(root.right);
    }

    private int getNumOfNodes(TreeNode root) {
        if ( root == null) return 0;
        return 1+ getNumOfNodes(root.left) + getNumOfNodes(root.right);
    }

    private boolean validateBST(TreeNode root) {
        return dfs( root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if ( root == null) return true;
        if ( root.val <= minValue || root.val >= maxValue) return false;
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }


    class Node{
        int max, min, maxSize;

        public Node(int min, int max, int maxSize) {
            this.min = min;
            this.max = max;
            this.maxSize = maxSize;
        }
    }
    public int largestBST(TreeNode root) {
        return dfsHelper(root).maxSize;
    }

    private Node dfsHelper(TreeNode root) {
        if ( root == null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Node left = dfsHelper(root.left);
        Node right = dfsHelper(root.right);
        if ( root.val > left.max &&  root.val < right.min) return new Node( Math.min(root.val, left.min), Math.max(root.val, right.max), 1+left.maxSize+right.maxSize);
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

}
