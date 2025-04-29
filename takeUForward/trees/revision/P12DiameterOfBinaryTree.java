package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

public class P12DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       if ( root == null) return 0;
       int leftHeight = findHeight(root.left);
       int rightHeight = findHeight(root.right);
       max = Math.max( max, leftHeight+rightHeight);
       diameterOfBinaryTree(root.left);
       diameterOfBinaryTree(root.right);
       return max;
    }

    private int findHeight(TreeNode root) {
        if ( root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right)+1;
    }

    public int diameterOfBinaryTreeOptimized(TreeNode root) {
        dfsHeight(root);
        return max;
    }

    private int dfsHeight(TreeNode root) {
        if ( root == null) return 0;
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        max = Math.max( max, left+ right);
        return Math.max(left, right)+1;
    }
}
