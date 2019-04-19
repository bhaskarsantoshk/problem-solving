package LeetCode;

public class P101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(s== null || t== null){
            return s== null && t== null;
        }
        return isSame(s.left , t.right) && isSame(s.right, t.left);
    }
}
