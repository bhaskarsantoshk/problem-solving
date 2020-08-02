package books.EPI.BinaryTrees;

public class SymmetricTreeUtil {
    public static boolean checkSymmetric(BinaryTreeNode<Integer> tree){
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(BinaryTreeNode<Integer> tree1, BinaryTreeNode<Integer> tree2) {
        if ( tree1 == null && tree2 == null ){
            return true;
        }
        if ( tree1 == null || tree2 == null ){
            return false;
        }
        return tree1.data == tree2.data && checkSymmetric(tree1.left, tree2.right) && checkSymmetric(tree1.right, tree2.left);
    }
}
