package company.google.trees_and_graphs;

import company.TreeNode;

public class P222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if ( root == null ) return 0;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesOptimized(TreeNode root) {
        if ( root == null ) return 0;
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if ( leftDepth == rightDepth ) return (1 << leftDepth) -1;
        return 1 + countNodesOptimized(root.left) + countNodesOptimized(root.right);
    }

    private int rightDepth(TreeNode root) {
        int depth = 0;
        while ( root != null ){
            root = root.right;
            depth++;
        }
        return depth;
    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while ( root != null ){
            root = root.left;
            depth++;
        }
        return depth;
    }
}
