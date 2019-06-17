package LeetCode;

public class P222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if ( root == null ) return 0;
        return 1+ countNodes(root.left) + countNodes(root.right);
    }
}
