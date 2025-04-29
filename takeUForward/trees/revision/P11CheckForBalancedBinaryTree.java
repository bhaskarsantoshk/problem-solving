package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

public class P11CheckForBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if ( root == null ) return true;
        int lH = getHeight(root.left);
        int rH = getHeight(root.right);
        if ( Math.abs(lH-rH) >1 ) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if ( root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1+ Math.max( leftHeight, rightHeight);
    }

    public boolean isBalancedOptimized (TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if ( root == null ) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if ( leftHeight == -1 || rightHeight == -1) return -1;
        if ( Math.abs(leftHeight-rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight)+1;
    }
}
