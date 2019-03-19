package interviewbit.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(a == null){
            return result;
        }
        TreeNode node = a;
        while ( !stack.isEmpty() || node!=null){
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

    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }
}
