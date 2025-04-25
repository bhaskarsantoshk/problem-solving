package takeUForward.trees.revision2;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        // LRD -> DRL ( pre order with slight tweak )
        List<Integer> res = new ArrayList<>();
        if ( root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while ( !stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
