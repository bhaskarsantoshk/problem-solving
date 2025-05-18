package takeUForward.binaryTrees.traversals;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P2PreorderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while ( !stack.isEmpty()){
            node = stack.pop();
            result.add(node.val);
            if ( node.right != null) stack.push(node.right);
            if ( node.left != null) stack.push(node.left);
        }
        return result;
    }
}
