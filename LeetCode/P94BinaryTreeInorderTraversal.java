package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inOrder(result, root);
        return result;
    }

    private void inOrder(List<Integer> result, TreeNode root) {
        if( root == null ) return;
        if(root.left != null) {
            inOrder(result, root.left);
        }
        result.add(root.val);
        if(root.right != null) {
            inOrder(result, root.right);
        }
    }

    public List<Integer> inorderIterative(TreeNode root) {
        if(root == null){
            return  null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while( !stack.isEmpty() || node != null){
            if(node != null ){
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
