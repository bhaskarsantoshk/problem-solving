package takeUForward.trees;

import java.util.Stack;

public class PostOrder {
    public void postOrder(TreeNode root){
        if ( root == null ) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }


     /*
              1
           2     3
        4     5
            6    7

          pre - 1 2 4 5 6 7 3
          post - 4 6 7 5 2 3 1
     */

    public void postOrderIterative(TreeNode root){
        if ( root == null ) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(root);
        while ( !stack.isEmpty() ){
            TreeNode node = stack.pop();
            // Print it - for inorder
            stack2.push(node.val);
            // For post-order, we first need to process the left and then the right.
            // Since stack is LIFO, push right first so that left is processed first.
            if ( node.right != null ) stack.push(node.right);
            if ( node.left != null ) stack.push(node.left);
        }
        // Now, print the elements in stack2 which will give the post-order traversal.
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
    }
}
