package company.microsoft.trees;

import company.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return root;
        if ( root.val == p.val || root.val == q.val ) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if ( left != null && right != null) return root;
        return ( left != null ) ? left : right;
    }
}
