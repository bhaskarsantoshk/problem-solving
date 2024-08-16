package takeUForward.trees;

public class P110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if ( root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if ( Math.abs(leftHeight-rightHeight) > 1) return false;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }

    private int height(TreeNode root) {
        if ( root == null ) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }

    public boolean isBalancedOptimized(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if ( root == null ) return 0;
        int left = dfsHeight(root.left);
        if ( left == -1 ) return -1;
        int right = dfsHeight(root.right);
        if ( right == -1 ) return -1;
        if ( Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
