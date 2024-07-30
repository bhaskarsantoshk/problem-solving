package striver_sde_sheet.binarytree;

import com.sun.source.tree.Tree;
import company.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if ( root == null ) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if ( root == null ) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while ( !stack.isEmpty() || node != null ){
            if ( node != null ){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

}
