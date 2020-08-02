package books.EPI.BinaryTrees;

public class HeightBalancedTree {


    public static boolean isBalanced(BinaryTreeNode<Integer> tree ){
        return checkBalanced(tree).balanced;
    }

    private static BalancedStatusWithHeight checkBalanced(BinaryTreeNode<Integer> tree) {
        if ( tree == null ){
            return new BalancedStatusWithHeight(true, -1); //Base case
        }
        BalancedStatusWithHeight leftResult = checkBalanced(tree.left);
        if ( !leftResult.balanced){
            return leftResult;
        }
        BalancedStatusWithHeight rightResult = checkBalanced(tree.right);
        if(!rightResult.balanced){
            return rightResult;
        }
        boolean isBalanced = Math.abs( leftResult.height -rightResult.height ) <=1 ;
        int height = Math.max(leftResult.height, rightResult.height);
        return new BalancedStatusWithHeight(isBalanced, height);
    }

    private static class BalancedStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalancedStatusWithHeight(boolean balanced, int height){
            this.balanced = balanced;
            this.height = height;
        }
    }
}
