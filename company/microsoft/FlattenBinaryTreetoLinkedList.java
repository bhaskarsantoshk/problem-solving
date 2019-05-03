package company.microsoft;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
    public TreeNode flatten(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode node = result;
        result.right = node;
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            node.right = popped;
            node.left = null;
            node = node.right;
            if(popped.right!=null){
                stack.push(popped.right);
            }
            if(popped.left!= null){
                stack.push(popped.left);
            }
        }
        return result.right;
    }
}
