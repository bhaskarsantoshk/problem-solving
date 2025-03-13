package takeUForward.blind75.tree;

import company.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if ( root == null ) return false;
        if ( isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if ( s == null || t == null) return s == null && t == null;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
