package company.google.trees_and_graphs;

import company.TreeNode;

public class P543DiameterOfBinaryTree {
    int max ;
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null ) return 0;
        max = Integer.MIN_VALUE;
        dfs( root);
        return max;
    }

    private int dfs(TreeNode root) {
        if ( root == null ) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
}
