package striver_sde_sheet.binarytree;

import company.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if ( root == null ) return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if ( root == null ) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while ( !stack.isEmpty() || node != null ){
            if ( node != null ){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }


}
