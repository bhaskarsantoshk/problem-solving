package company.microsoft.trees;


import company.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if ( root == null ) return true;
        if ( root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left , minValue, root.val) &&
                isValidBST(root.right, root.val , maxValue);
    }


    // Iterative way
    // Inorder Traversal - Learn it as a pre-requisite
    public List<Integer> inOrder(TreeNode root){
        if ( root == null ) return null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while ( root != null || !stack.isEmpty()){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public boolean isValidBSTIterative(TreeNode root){
        if ( root == null ) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while ( root != null || !stack.isEmpty()){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( prev != null && prev.val >= root.val ) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }

}
