package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P1382BalanceABinarySearchTree {
    List<TreeNode> sortedArray = new ArrayList<TreeNode>();
    public TreeNode balanceBST(TreeNode root) {
       inorder(root);
       return sortedArrayToBST(0, sortedArray.size()-1);
    }

    private TreeNode sortedArrayToBST(int start, int end) {
        if ( start > end ) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedArray.get(mid);
        root.left = sortedArrayToBST(start, mid-1);
        root.right = sortedArrayToBST(mid+1, end);
        return root;
    }

    private void inorder(TreeNode root) {
        if ( root == null ) return;
        inorder(root.left);
        sortedArray.add(root);
        inorder(root.right);
    }
}
