package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

public class P14CheckForSymmetricalBTs {
    public boolean isSymmetric(TreeNode root) {
       if ( root == null) return true;
       return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if ( s == null && t == null) return true;
        if ( s == null || t == null || s.val != t.val) return false;
        return isSameTree(s.left, t.right) && isSameTree(s.right, t.left);
    }
}
