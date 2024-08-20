package company.google;

import company.TreeNode;

public class P222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // complete tree with all nodes filled - if height is h , nodes = 2^n -1;
        // what if the right leafs are not filled
        // total = 1 + leftSubtree + rightSubTree
        // if lh == rh , complete binary tree with all leaves 2^h -1
        if ( root == null) return 0;
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth( root);
        if ( leftDepth == rightDepth) return (1 << leftDepth) -1;
        return 1+ countNodes(root.left)+countNodes(root.right);
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
