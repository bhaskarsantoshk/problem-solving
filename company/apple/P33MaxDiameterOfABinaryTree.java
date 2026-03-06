package company.apple;

public class P33MaxDiameterOfABinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(max, leftHeight+rightHeight);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    private int height(TreeNode root) {
        if ( root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1+ Math.max(left, right);
    }

    int maxi = 0;
    public int maxDiameter(TreeNode root){
        dfsHeight(root);
        return maxi;
    }

    private int dfsHeight(TreeNode root) {
        if ( root == null) return 0;
        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);
        maxi = Math.max(maxi, left+right);
        return 1+ Math.max(left, right);
    }


}
