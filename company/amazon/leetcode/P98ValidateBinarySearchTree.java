package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if ( root == null ) return true;
        if ( root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    // Approach2 : Iterative
    // Pre-requisite - know iterative inorder traversal
    public List<Integer> inorderTraversal (TreeNode root){
        List<Integer> res = new ArrayList<>();
        if ( root == null ) return res;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    // Solution
    public boolean isValidBinarySearchTree(TreeNode root){
        if ( root == null ) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while ( root != null || !stack.isEmpty()){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

}
