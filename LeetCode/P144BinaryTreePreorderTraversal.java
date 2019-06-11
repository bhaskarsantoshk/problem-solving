package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            preOrder(root.left, list);
        }
        if(root.right != null){
            preOrder(root.right, list);
        }
    }

    public List<Integer> preorderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if ( root == null ){
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        while ( !stack.isEmpty() ){
            node = stack.pop();
            list.add(node.val);
            if ( node.right != null ){
                stack.push(node.right);
            }
            if ( node.left != null  ){
                stack.push( node.left );
            }
        }
        return list;
    }
}
