package company.google.trees_and_graphs;

import company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P124BinaryTreeMaximumPathSum {
    int max;
    public int maxPathSumRec(TreeNode root) {
        if ( root == null ) return 0;
        max = Integer.MIN_VALUE;
        maxPathRec(root);
        return max;
    }

    private int maxPathRec(TreeNode root){
        if ( root == null ) return 0;
        int leftPathSum = Math.max(0, maxPathRec(root.left));
        int rightPathSum = Math.max(0, maxPathRec(root.right));
        max = Math.max( max, leftPathSum+ rightPathSum+ root.val);
        return Math.max(leftPathSum, rightPathSum)+ root.val;
    }

    public int maxPathSumMemoized(TreeNode root) {
        if ( root == null ) return 0;
        max = Integer.MIN_VALUE;
        Map<TreeNode, Integer> memo= new HashMap<>();
        maxPathMemoized(root, memo);
        return max;
    }

    private int maxPathMemoized(TreeNode root, Map<TreeNode, Integer> memo){
        if ( root == null ) return 0;
        if ( memo.containsKey(root) ) return memo.get(root);
        int leftPathSum = Math.max(0, maxPathMemoized(root.left, memo));
        int rightPathSum = Math.max(0, maxPathMemoized(root.right, memo));
        max = Math.max( max, leftPathSum+ rightPathSum+ root.val);
        int result = Math.max(leftPathSum, rightPathSum)+ root.val;
        memo.put(root, result);
        return result;
    }
}

/*
      1
   2     3
 3   4

 */
