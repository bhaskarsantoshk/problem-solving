package company.amazon.leetcode;

public class P543DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if ( root == null ) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(left+right, max); // by definition, Diameter is the max num of edges between two nodes,not the num of nodes hence we are not adding a +1
        return Math.max(left, right)+1;
    }
}
