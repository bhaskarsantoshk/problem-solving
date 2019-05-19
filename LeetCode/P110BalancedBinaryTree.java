package LeetCode;

public class P110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null ) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if(root == null ){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right)+1;
    }

}
