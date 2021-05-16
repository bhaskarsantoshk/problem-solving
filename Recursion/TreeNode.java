package Recursion;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }

    public static void printInorder (TreeNode root){
        if ( root == null ) return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }
}
