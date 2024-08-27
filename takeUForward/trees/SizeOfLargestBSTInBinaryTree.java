package takeUForward.trees;

import LeetCode.Node;

public class SizeOfLargestBSTInBinaryTree {
    static class TreeNodeValue{
        int maxNode, minNode, maxSize;

        public TreeNodeValue(int maxNode, int minNode, int size) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = size;
        }
    }

    public static int largestBST(TreeNode root) {
        return largestBSThelper(root).maxSize;
    }

    private static TreeNodeValue largestBSThelper(TreeNode root) {
        if ( root == null ) return new TreeNodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        TreeNodeValue left = largestBSThelper(root.left);
        TreeNodeValue right = largestBSThelper(root.right);
        if ( left.maxNode < root.val && root.val < right.minNode){
            // It is a BST
            int minNode = Math.min(root.val, left.minNode);
            int maxNode = Math.max(root.val, right.maxNode);
            int maxSize = left.maxSize + right.maxSize + 1;
            return new TreeNodeValue(minNode, maxNode, maxSize);
        }
        return new TreeNodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}
