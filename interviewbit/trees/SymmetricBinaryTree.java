package interviewbit.trees;

public class SymmetricBinaryTree {
    public int isSymmetric(TreeNode A) {
        if (A == null){
            return 1;
        }
        if(A.left == null && A.right == null){
            return 1;
        }
        if(A.left == null || A.right == null){
            return 0;
        }
        return isMirror(A.left, A.right) ? 1: 0;
    }

    private boolean isMirror(TreeNode A, TreeNode B) {
        if(A == null && B== null){
            return true;
        }
        if(A== null || B==null){
            return false;
        }
        return A.val == B.val && isMirror(A.left, B.right) && isMirror(A.right, B.left);
    }
}
