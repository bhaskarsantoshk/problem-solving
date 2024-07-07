package express_prep.amzn.top_voted;

import java.util.Stack;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty()) {
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    // Recursion
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder( root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if ( root == null ) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);

    }
}
