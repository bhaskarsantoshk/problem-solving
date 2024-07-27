package striver_sde_sheet.binarytree;
import company.TreeNode;

public class P104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if ( root == null ) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+ Math.max( left, right);
    }
}
