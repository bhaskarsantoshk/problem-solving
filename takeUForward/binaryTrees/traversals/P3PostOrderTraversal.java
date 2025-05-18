package takeUForward.binaryTrees.traversals;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class P3PostOrderTraversal {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.push(node);
        while ( !stack.isEmpty()){
            node = stack.pop();
            result.add(node.val);
            if ( node.left != null) stack.push(node.left);
            if ( node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }
}
