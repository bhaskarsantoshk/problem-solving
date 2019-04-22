package LeetCode;

import java.util.ArrayList;

public class P437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null ) return 0;
        return dfs(root, sum) + pathSum(root.left, sum-root.val) + pathSum(root.right, sum-root.val);
    }

    private int dfs( TreeNode root, int sum) {
        if (root == null ) return 0;
        return (root.val == sum) ? 1: 0
                + dfs(root.left, sum-root.val) + dfs(root.right, sum-root.val);

    }
}
