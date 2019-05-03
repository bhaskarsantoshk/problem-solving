package company.microsoft;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A!=null){
            helper(A);
        }
        return result;
    }

    private void helper(TreeNode A) {
        result.add(A.val);
        if(A.left != null){
            helper(A.left);
        }
        if (A.right != null){
            helper(A.right);
        }
    }

    public ArrayList<Integer> preOrderIterative(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(root.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }

}
