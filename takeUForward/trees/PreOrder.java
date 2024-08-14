package takeUForward.trees;

public class PreOrder {
    public void preOrder( TreeNode root ){
        if ( root == null ) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
