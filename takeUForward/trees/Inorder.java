package takeUForward.trees;
import java.util.Stack;

public class Inorder {
    public void inOrder(TreeNode root){
        if ( root == null ) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /*
              1
           2     3
        4     5
            6    7

          4 2 6 5 7 1 3
     */

    public void inOrderIterative(TreeNode root){
        if ( root == null ) return;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while ( !stack.isEmpty() || node != null){
            while ( node != null ) {
                stack.push(root);
                node = node.left;
            }
            node= stack.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }
}
