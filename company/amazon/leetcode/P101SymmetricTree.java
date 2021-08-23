package company.amazon.leetcode;

public class P101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode s, TreeNode t) {
        if ( s == null || t == null ) return s == null && t == null;
        return s.val == t.val && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
    }
}
