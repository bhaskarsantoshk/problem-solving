package takeUForward.google;
import takeUForward.google.common_ds.TreeNode;

public class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if ( root == null) return null;
        if ( root.data == val) return root;
        if ( root.data < val ) return searchBST(root.right, val);
        return searchBST(root.left, val);
    }
}
