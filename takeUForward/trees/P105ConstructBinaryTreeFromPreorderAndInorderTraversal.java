package takeUForward.trees;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0,preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if ( inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode (preorder[preStart]);
        int index = -1;
        for ( int i=inStart; i<=inEnd; i++){
            if ( inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = buildTree(preorder, preStart+1, preEnd,inorder, inStart, index-1);
        root.right = buildTree(preorder, preStart+index+1-inStart, preEnd, inorder, index+1, inEnd );
        return root;
    }
}
