package company.microsoft.trees;

public class P112PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if ( root == null ) return false;
        if ( root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }

    class TreeNode {
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        int val;
        TreeNode left, right;

    }
}
