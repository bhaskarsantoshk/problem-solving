package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class P230KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = inorder(root, new ArrayList<>());
        return result.get(k-1);
    }

    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> result) {
        if ( root == null ){
            return result;
        }
        if(root.left != null) {
            inorder(root.left, result);
        }
        result.add(root.val);
        if(root.right != null ){
            inorder(root.right, result);
        }
        return result;
    }

    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack  = new Stack<TreeNode>();
        while(true){
            while( root!= null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0){
                return root.val;
            }
            root = root.right;
        }
    }
}
