package books.EPI.BinaryTrees;

public class SumRootToLeafUtil {
    public static int sumRootToLeaf(BinaryTreeNode<Integer> root){
        return sumRootToLeafHelper(root, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> root, int partialPathSum) {
        if ( root == null ){
            return 0;
        }
        partialPathSum = partialPathSum * 2 + root.data;
        if ( root.left == null && root.right == null ){
            return partialPathSum;
        }
        return sumRootToLeafHelper(root.left, partialPathSum) + sumRootToLeafHelper(root.right, partialPathSum);
    }
}
