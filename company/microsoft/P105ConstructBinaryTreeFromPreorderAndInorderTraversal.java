package company.microsoft;

public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if ( inStart > inEnd || preStart >= preorder.length) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for ( int i=inStart; i<=inEnd; i++){
            if ( inorder[i] == preorder[preStart]){
                inIndex = i; break;
            }
        }
        root.left = buildTree(preorder, preStart+1, inorder, inStart, inIndex-1);
        root.right = buildTree(preorder, preStart+inIndex+1-inStart, inorder, inIndex+1, inEnd);
        return root;
    }
}
