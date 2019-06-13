package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class P145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.left != null){
            postOrder(root.left, list);
        }
        if(root.right != null){
            postOrder(root.right, list);
        }
        list.add(root.val);

    }

    public List<Integer> postOrderIterative( TreeNode root ){
     List<Integer> list = new ArrayList<>();
     if ( root == null ) return list;
     Stack<TreeNode> stack = new Stack<>();
     TreeNode node = root;

     while ( !stack.isEmpty() || node != null ){
         if ( node != null ){
             stack.push(node);
             node = node.left;
         }
         else{
             TreeNode temp = stack.peek().right;
             if ( temp == null ) {
                 temp = stack.pop();
                 list.add(temp.val);

                 while (!stack.isEmpty() && temp == stack.peek().right) {
                     temp = stack.pop();
                     list.add(temp.val);
                 }
             }
             else{
                 node = temp;
             }
             }
         }

         return list;
     }

    }
}
