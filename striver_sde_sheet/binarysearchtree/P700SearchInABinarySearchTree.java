package striver_sde_sheet.binarysearchtree;

import company.TreeNode;

public class P700SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if ( root == null ) return null;
        if ( root.val == val ) return root;
        if ( root.val > val ) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        if ( root == null ) return null;
        TreeNode node = root;
        while ( node != null ){
            if ( node.val == val ) return node;
            node = node.val > val ? node.left: node.right;
        }
        return null;
    }

}
