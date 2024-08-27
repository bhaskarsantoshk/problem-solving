package takeUForward.trees;

public class P700SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
       if ( root == null ) return null;
       if ( root.val == val) return root;
       if ( root.val > val) return searchBST(root.left, val);
       return searchBST(root.right, val);
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {
        while (root != null && root.val != val){
            root = ( root.val > val) ? root.left: root.right;
        }
        return root;
    }
}
