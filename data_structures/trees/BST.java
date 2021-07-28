package data_structures.trees;

public class BST {
    static TreeNode prev = null;
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

    public static boolean isBSTOptimized (TreeNode root){
        if ( root == null ){
            return true;
        }
        if ( !isBSTOptimized(root.left)){
            return false;
        }
        if ( prev != null && prev.data >= root.data){
            return false;
        }
        prev = root;
        if ( !isBSTOptimized(root.right)){
            return false;
        }
        return true;
    }
}
