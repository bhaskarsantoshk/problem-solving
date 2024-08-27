package takeUForward.trees;

public class P99RecoverBinarySearchTree {
    TreeNode first, prev, middle, last;
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if ( first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if ( first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if ( root == null) return;
        inorder(root.left);
        if ( prev != null && root.val < prev.val ){
            if ( first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
