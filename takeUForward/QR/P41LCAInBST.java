package takeUForward.QR;

public class P41LCAInBST {
    public TreeNode lca(TreeNode root, int p, int q) {
        if ( root == null || root.data == p || root.data == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if ( left == null) return right;
        else if ( right == null) return left;
        else return root;
    }
}
