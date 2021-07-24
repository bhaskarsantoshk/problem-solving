package data_structures.trees;

import java.util.Stack;

public class InorderTraversal {
    public void inorderTraversal ( TreeNode node){
        if ( node == null ) return;
        Stack<TreeNode> stack = new Stack<>();
        while ( !stack.isEmpty() || node != null ){
            if ( node != null ) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

    public void inorder(TreeNode root){
        if ( root == null ) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
}
