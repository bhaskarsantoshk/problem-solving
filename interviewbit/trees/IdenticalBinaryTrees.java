package interviewbit.trees;

public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        return isSameTrees(A,B) ? 1: 0;
    }
    private boolean isSameTrees(TreeNode a, TreeNode b) {
        if(a==null || b==null){
            return a==null && b==null;
        }
        return a.val==b.val && isSameTrees(a.left,b.left) && isSameTrees(a.right,b.right);
    }
}
