package takeUForward.trees.revision2;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if ( root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while ( !stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if ( node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }
}
