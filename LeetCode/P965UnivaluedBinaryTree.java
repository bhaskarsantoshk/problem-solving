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
}
