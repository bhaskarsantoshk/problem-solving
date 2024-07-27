package striver_sde_sheet.binarytree;

import company.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if ( root == null ) return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if ( root == null ) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = root;
        stack1.push(node);
        while ( !stack1.isEmpty()){
            node = stack1.pop();
            stack2.push(node);
            if ( node.left != null ){
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while ( !stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }
}
