package microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        if(a!=null){
            inorderRec(a);
        }
        return result;
    }

    private void inorderRec(TreeNode root) {
        if(root== null){
            return;
        }
        if(root.left!=null) {
            inorderRec(root.left);
        }
        result.add(root.val);
        if(root.right!=null){
            inorderRec(root.right);
        }
    }

    public ArrayList<Integer> inOrderIterative(TreeNode root) {
        if(root == null){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node!=null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
