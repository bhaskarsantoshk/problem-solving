package interviewbit.dynamic_programming;

public class MaxSumPathinBinaryTree {
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode A) {
        if ( A == null ) return 0;
        maxPath(A);
        return max;
    }
    private int maxPath( TreeNode root ){
        if ( root == null ){
            return 0;
        }
        int left = Math.max (0, maxPath( root.left));
        int right = Math.max (0, maxPath( root. right ));
        max = Math.max ( left+ right+ root.val , max);
        return Math.max ( left, right) + root.val;
    }
}
