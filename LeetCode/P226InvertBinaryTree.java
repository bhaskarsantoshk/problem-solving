package LeetCode;

public class P226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if( root == null ) return  null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
