package LeetCode;

public class P687LongestUnivaluePath {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        longestUnivaluePathUtil(root);
        return ans;
    }

    private int longestUnivaluePathUtil(TreeNode root) {
        if ( root == null ) return 0;
        int left = longestUnivaluePathUtil(root.left);
        int right = longestUnivaluePathUtil(root.right);
        int extendedLeft = 0, extendedRight= 0;
        if ( root.left != null && root.left.val == root.val){
            extendedLeft+= left+1;
        }
        if (root.right != null && root.right.val == root.val){
            extendedRight+= right+1;
        }
        ans = Math.max(ans, extendedLeft+extendedRight);
        return Math.max (extendedLeft, extendedRight);
    }
}
