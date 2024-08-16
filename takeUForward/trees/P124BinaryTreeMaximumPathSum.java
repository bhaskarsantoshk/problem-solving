package takeUForward.trees;

public class P124BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if ( root == null ) return 0;
        int left = maxPathThatPassViaNode(root.left);
        int right = maxPathThatPassViaNode(root.right);

        // Calculate max including both children, or just root, or root with one of the children
        max = Math.max(max, Math.max(left + right + root.val, Math.max(root.val, root.val + Math.max(left, right))));
        maxPathSum(root.left);
        maxPathSum(root.right);
        return max;
    }

    private int maxPathThatPassViaNode(TreeNode root) {
        if ( root == null ) return 0;
        int left = maxPathThatPassViaNode(root.left);
        int right = maxPathThatPassViaNode(root.right);
        return Math.max(Math.max(left, right), 0) + root.val;
    }

    // int max = Integer.MIN_VALUE;
    public int maxPathSumOptimized(TreeNode root) {
        dfsPathSum(root);
        return max;
    }

    private int dfsPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max( 0, dfsPathSum(root.left));
        int right = Math.max( 0, dfsPathSum(root.right));
        max = Math.max( max, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
