package books.EPI.BinaryTrees;

public class HasPathSumUtil {
    public static boolean hasPathSum(BinaryTreeNode<Integer> root, int sum ){
        if ( root == null ) return false;
        if (root.left == null && root.right == null ) return root.data == sum;
        return hasPathSum(root.left, sum-root.data) ||
                hasPathSum(root.right, sum-root.data);
    }
}

// Time: O(n), Space: O(h)
