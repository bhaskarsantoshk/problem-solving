package company.amazon.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode s, TreeNode t) {
        if ( s == null || t == null ) return s == null && t == null;
        return s.val == t.val && isSymmetric(s.left, t.right) && isSymmetric(s.right, t.left);
    }

    public boolean isSymmetricIterative( TreeNode root ){
        if ( root == null ) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while ( !queue.isEmpty()){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if ( f == null && s == null ) continue;
            if ( f == null || s == null || f.val != s.val) return false;
            queue.add(f.left);
            queue.add(s.right);
            queue.add(f.right);
            queue.add(s.left);
        }
        return true;
    }
}
