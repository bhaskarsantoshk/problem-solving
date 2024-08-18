package takeUForward.trees;

public class P101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null) return true;
        return isSymmetricHelper( root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if ( left == null || right == null) return left== null && right==null;
        return left.val == right.val
                && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
    }
}
