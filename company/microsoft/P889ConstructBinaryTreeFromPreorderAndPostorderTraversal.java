package company.microsoft;

public class P889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/solutions/161372/java-python-divide-and-conquer-with-explanation/comments/179456/
    static int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preIndex = 0; // Reset for safety
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int[] post, int postStart, int postEnd) {
        TreeNode root = new TreeNode(pre[preIndex++]);

        if (postStart == postEnd || preIndex >= pre.length)
            return root;

        int i = postStart;
        while (post[i] != pre[preIndex]) i++;

        root.left = buildTree(pre, post, postStart, i);

        // ✅ Only build right if there's something to build
        if (i + 1 <= postEnd - 1)
            root.right = buildTree(pre, post, i + 1, postEnd - 1);

        return root;
    }
}
