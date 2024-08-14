package takeUForward.trees;

public class PostOrder {
    public void postOrder(TreeNode root){
        if ( root == null ) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
}
