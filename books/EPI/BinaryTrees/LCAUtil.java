package books.EPI.BinaryTrees;

public class LCAUtil {

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> root,
                                              BinaryTreeNode<Integer> p,
                                              BinaryTreeNode<Integer> q){
        return LCAHelper(root, p, q).ancestor;
    }

    private static Status LCAHelper(BinaryTreeNode<Integer> root,
                                    BinaryTreeNode<Integer> p,
                                    BinaryTreeNode<Integer> q) {
        if ( root == null ) return new Status(0, null);
        Status leftResult = LCAHelper(root.left, p, q);
        if ( leftResult.numTargetNodes == 2){
            return leftResult;
        }
        Status rightResult = LCAHelper(root.right, p, q);
        if ( rightResult.numTargetNodes == 2){
            return rightResult;
        }
        int numTargetNodes = leftResult.numTargetNodes +
                rightResult.numTargetNodes +
                (root == p ? 1:0) + (root==q?1:0);
        return new Status(numTargetNodes, numTargetNodes==2 ? root: null);
    }


    private static class Status{
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> node){
            this.numTargetNodes = numTargetNodes;
            this.ancestor = node;
        }
    }
}
