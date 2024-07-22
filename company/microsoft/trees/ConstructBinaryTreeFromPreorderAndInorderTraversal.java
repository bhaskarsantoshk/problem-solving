package company.microsoft.trees;

import company.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder , int inStart, int inEnd){
        if ( preStart > preEnd  || inStart > inEnd ) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for ( int i=inStart; i<inEnd; i++){
            if ( inorder[i] == root.val){
                inIndex= i;
                break;
            }
        }
        root.left = buildTree(preorder, preStart+1, preEnd-inIndex+1, inorder, inStart, inIndex-1);
        root.right = buildTree(preorder, preStart+inIndex-inStart+1,preEnd, inorder, inIndex+1, inEnd);
        return root;
    }
}
