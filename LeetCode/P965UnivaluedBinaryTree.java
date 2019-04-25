package LeetCode;

import java.util.Stack;

public class P965UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
       return dfs(root, root.val);
    }
    public boolean dfs(TreeNode root, int v){
        if(root == null ) return true;
        if(root.val != v) return false;
        return dfs(root.left, v) && dfs(root.right, v);
    }

    public boolean isUnivalTreeIterative(TreeNode root){
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node!=null){
            if(node!=null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                if(node.val != root.val) return false;
                node = node.right;
            }
        }
        return true;
    }
}
