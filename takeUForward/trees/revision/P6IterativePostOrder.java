package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class P6IterativePostOrder {
    public List<Integer> postorder(TreeNode root) {
       if ( root == null) return null;
       List<Integer> res = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode node = root;
       stack.push(node);
       while ( !stack.isEmpty()){
           node = stack.pop();
           res.add(node.val);
           if ( node.left != null) stack.push(node.left);
           if ( node.right != null ) stack.push(node.right);
       }
        Collections.reverse(res);
       return res;
    }
}
