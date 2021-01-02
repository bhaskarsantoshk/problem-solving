package Leetcode.explore.recursion;

public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if ( root == null ) return 0;
        if ( root.left == null && root.right == null ) return 1;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
}