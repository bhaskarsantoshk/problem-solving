package takeUForward.blind75.tree;

import company.TreeNode;

public class MaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root){
        if ( root == null) return 0;
        int leftSum = Math.max(0, maxPath(root.left));
        int rightSum = Math.max(0, maxPath(root.right));
        max = Math.max(max, leftSum+rightSum+ root.val);
        return root.val + Math.max(leftSum, rightSum);
    }
}
