package takeUForward.trees;

import java.util.HashMap;
import java.util.Map;

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

    public TreeNode buildTreeOptimized(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTreeOptimized(preorder, 0,preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private TreeNode buildTreeOptimized(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {
        if ( inStart > inEnd || preStart > preEnd) return null;
        TreeNode root = new TreeNode (preorder[preStart]);
        int index = inOrderMap.get(root.val);
        root.left = buildTreeOptimized(preorder, preStart+1, preEnd,inorder, inStart, index-1, inOrderMap);
        root.right = buildTreeOptimized(preorder, preStart+index+1-inStart, preEnd, inorder, index+1, inEnd, inOrderMap);
        return root;
    }
}
