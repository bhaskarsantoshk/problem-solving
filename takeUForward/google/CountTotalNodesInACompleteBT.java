package takeUForward.google;

import takeUForward.google.common_ds.TreeNode;

public class CountTotalNodesInACompleteBT {
    int count = 0;
    public int countNodes(TreeNode root) {
        if ( root == null ) return null;
        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    public int countNodesWithoutGlobalVariable(TreeNode root) {
        if ( root == null ) return 0;
        if ( root.left == null && root.right == null ) return 1;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    public int countNodesOptimal(TreeNode root) {
        if ( root == null ) return 0;
        int leftHeight = getLeftHeight( root);
        int rightHeight = getRightHeigt(root);
        if ( leftHeight == rightHeight) return (1 << leftHeight)-1;
        return 1+ countNodesOptimal(root.left) + countNodesOptimal(root.right);
    }

    private int getRightHeigt(TreeNode root) {
        int count  = 0;
        while (root != null){
            root = root.right;
            count++;
        }
        return count;
    }

    private int getLeftHeight(TreeNode root) {
        int count  = 0;
        while (root != null){
            root = root.left;
            count++;
        }
        return count;
    }
}
