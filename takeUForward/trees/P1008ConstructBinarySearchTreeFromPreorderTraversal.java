package takeUForward.trees;

public class P1008ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Long.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorder(int[] preorder, long upperBound, int[] i) {
        if ( i[0] == preorder.length || preorder[i[0]] > upperBound) return null;
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, upperBound, i);
        return root;
    }
}
