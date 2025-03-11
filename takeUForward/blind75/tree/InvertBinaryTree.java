package takeUForward.blind75.tree;

import company.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if ( root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
