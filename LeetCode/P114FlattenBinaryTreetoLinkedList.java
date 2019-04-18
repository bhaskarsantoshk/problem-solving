package LeetCode;

import java.util.Stack;

public class P114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode node = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            node.right = popped;
            node.left = null;
            node = node.right;
            if(popped.right != null){
                stack.push(popped.right);
            }
            if(popped.left != null){
                stack.push(popped.left);
            }
        }
    }
}
