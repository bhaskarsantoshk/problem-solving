package company.microsoft.trees;

import company.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestorBruteForce(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return null;
        if ( root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestorBruteForce(root.left, p, q);
        TreeNode right = lowestCommonAncestorBruteForce(root.right, p, q);
        if ( left != null && right != null) return root;
        return left != null ? left: right;
    }
}
