package takeUForward.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public void preOrder( TreeNode root ){
        if ( root == null ) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

     /*
              1
           2     3
        4     5
            6    7

         1 2 4 5 6 7 3
     */

    public List<Integer> preorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while ( !stack.isEmpty() ){
            TreeNode node = stack.pop();
            result.add(node.val);
            if ( node.right != null ) stack.push(node.right);
            if ( node.left != null ) stack.push(node.left);
        }
        return result;
    }
}
