package takeUForward.trees;

public class Inorder {
    public void inOrder(TreeNode root){
        if ( root == null ) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}
