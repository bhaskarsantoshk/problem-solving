package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P5IterativePreOrder {
    public List<Integer> preorder(TreeNode root) {
        if ( root == null) return null;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while ( !stack.isEmpty() ) {
            node = stack.pop();
            res.add(node.val);
            if ( node.right != null ) stack.push(node.right);
            if ( node.left != null) stack.push(node.left);
        }
        return res;
    }
}
