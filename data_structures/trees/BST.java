package data_structures.trees;

public class BST {
    public static boolean isBst(TreeNode root) {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBst(TreeNode root, int minValue, int maxValue) {
        if ( root == null) return true;
        if ( root.data < minValue || root.data > maxValue) {
            return false;
        }
        return isBst(root.left, minValue, root.data) && isBst(root.right, root.data, maxValue);
    }
}
