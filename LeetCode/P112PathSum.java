package LeetCode;

public class P112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && sum==root.val){
            return true;
        }
        return dfs(root.left, sum-root.val) || dfs(root.right, sum-root.val);
    }
}
