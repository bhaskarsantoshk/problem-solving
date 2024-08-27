package takeUForward.trees;

public class P701InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if ( root == null) return new TreeNode(val);
        TreeNode cur = root;
        while ( true){
            if ( cur.val <= val) {
                if ( cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    break;
                }
            } else {
                if ( cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBSTRec(TreeNode root, int val) {
        if ( root == null ) return new TreeNode(val);
        if( root.val > val){
            root.left = insertIntoBSTRec(root.left, val);
        }else {
            root.right = insertIntoBSTRec(root.right, val);
        }
        return root;
    }
}
