package striver_sde_sheet.binarysearchtree;

import company.TreeNode;

import java.util.Stack;

public class P98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) return true;
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer minValue, Integer maxValue) {
        if ( root == null ) return true;
        if ( (minValue != null && root.val <= minValue) || (maxValue != null && root.val >= maxValue)) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public boolean isValidBSTIterative(TreeNode root) {
        if ( root == null ) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while ( !stack.isEmpty() || node != null ){
            if ( node != null ){
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
