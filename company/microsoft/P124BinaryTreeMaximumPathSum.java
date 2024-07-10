package company.microsoft;

public class P124BinaryTreeMaximumPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if ( root == null ) return 0;
        int leftPathSum = Math.max ( 0, maxPath(root.left));
        int rightPathSum = Math.max (0, maxPath(root.right));
        max = Math.max( max , leftPathSum + rightPathSum + root.val);
        return Math.max(leftPathSum ,rightPathSum) + root.val;
    }

    // Pre-requite problems - Max Height of Binary Tree, Width of Binary Tree
    // Max depth/height of a binary tree
    // 1 + max ( l, r )
}
