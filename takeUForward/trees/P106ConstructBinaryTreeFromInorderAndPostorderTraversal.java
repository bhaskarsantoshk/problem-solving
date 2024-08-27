package takeUForward.trees;

import java.util.HashMap;
import java.util.Map;

public class P106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for ( int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inOrderMap);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inOrderMap) {
        if ( inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inOrderMap.get(root.val);
        int leftTreeSize = inIndex-inStart;
        root.left = buildTree(inorder, inStart, inIndex - 1, postorder, postStart, postStart + leftTreeSize - 1, inOrderMap);
        root.right = buildTree(inorder, inIndex + 1, inEnd, postorder, postStart + leftTreeSize, postEnd - 1, inOrderMap);
        return root;
    }
}
