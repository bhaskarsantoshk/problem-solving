package takeUForward.trees;

import java.util.Stack;

public class P114FlattenBinaryTreeToLinkedList {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if ( root == null ) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev= root;
    }

    public void flattenBinaryTree(TreeNode root) {
        if ( root == null ) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while ( !stack.isEmpty() ){
            TreeNode cur = stack.peek();
            stack.pop();
            if ( cur.right != null) stack.push(cur.right);
            if ( cur.left != null ) stack.push(cur.left);
            if ( !stack.isEmpty()) cur.right = stack.peek();
            cur.left = null;
        }
    }

    public void flattenBinaryTreeUsingMorrisTraversal(TreeNode root) {
        if ( root == null ) return;
        TreeNode cur = root;
        while ( cur != null ){
            if ( cur.left != null ){
                TreeNode prev = cur.left;
                while ( prev.right != null){
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
            }
            cur = cur.right;
        }
    }
}
