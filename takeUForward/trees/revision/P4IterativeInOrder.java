package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P4IterativeInOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root == null) return null;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true){
            if ( node != null ){
                stack.push(node);
                node = node.left;
            } else{
                if ( stack.isEmpty()) break;
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
