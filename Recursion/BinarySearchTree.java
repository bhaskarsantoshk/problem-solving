package Recursion;

import static Recursion.TreeNode.printInorder;

public class BinarySearchTree {
    public static TreeNode insertRecursively ( TreeNode root, int val){
        if ( root == null ) return new TreeNode(val);
        if ( root.val > val ){
            root.left = insertRecursively(root.left, val);
        } else if ( root.val < val ){
            root.right = insertRecursively(root.right, val);
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        insertRecursively(root, 0);
        insertRecursively(root, 4);
        printInorder(root); // 0 1 2 3 4
    }
}
