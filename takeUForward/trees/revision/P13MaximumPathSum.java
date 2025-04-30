package takeUForward.trees.revision;


import takeUForward.trees.TreeNode;

public class P13MaximumPathSum {
    int max = 0;
    public int maxPathSum(TreeNode root) {
        dfsMaxPath(root);
        return max;
    }

    private int dfsMaxPath(TreeNode root) {
        if ( root == null) return 0;
        int leftMaxPath = Math.max(0, dfsMaxPath(root.left));
        int rightMaxPath = Math.max(0, dfsMaxPath(root.right));
        max = Math.max( max, leftMaxPath+rightMaxPath+root.val);
        return root.val + Math.max(leftMaxPath, rightMaxPath);
    }
}
