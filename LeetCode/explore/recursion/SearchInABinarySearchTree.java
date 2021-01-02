package Leetcode.explore.recursion;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if ( root == null ) return null;
        if ( root.val == val ) return root;
        if (root.val > val ) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}

/*

url: https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3233/

*/