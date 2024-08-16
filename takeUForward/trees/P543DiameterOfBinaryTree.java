package takeUForward.trees;

public class P543DiameterOfBinaryTree {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null ) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(max, leftHeight+rightHeight);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    private int height(TreeNode root) {
        if ( root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max( left, right)+1;
    }

    // int  max = 0;
    public int diameterOfBinaryTreeOptimized(TreeNode root) {
        dfsHeight(root);
        return max;
    }

    private int dfsHeight(TreeNode root) {
        if ( root == null) return 0;
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        max = Math.max( max, left+right);
        return 1+ Math.max(left, right);
    }
}
