package takeUForward.trees;

import java.util.Stack;

public class P98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if ( root == null) return true;
        if ( root.val <= minValue  || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }


    public boolean isValidBSTIterative(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while ( node != null || !stack.isEmpty()) {
            if ( node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if ( prev != null && prev.val >= node.val) return false;
                prev = node;
                node = node.right;
            }
        }
        return true;
    }
}
