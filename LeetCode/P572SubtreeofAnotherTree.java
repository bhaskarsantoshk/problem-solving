package LeetCode;

public class P572SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
       if ( s == null ) return false;
       if ( isSame(s, t)){
           return true;
       }
       return isSame(s.left, t) || isSame(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if ( s == null || t ==null ){
            return s == null && t == null;
        }
        return s.val==t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
