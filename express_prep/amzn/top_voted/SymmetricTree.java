package express_prep.amzn.top_voted;


import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if ( root == null ) return true;
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if ( s == null || t == null ) return s == null && t == null;
        return s.val == t.val && isSameTree(s.left, t.right) && isSameTree(s.right, t.left);
    }

    public boolean isSymmetricIterative ( TreeNode root ){
        if ( root == null ) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while ( !queue.isEmpty() ){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if ( f == null && s == null ) continue;
            if ( f ==  null || s == null || f.val != s.val ) return false;
            queue.add(f.left);
            queue.add(s.right);
            queue.add(f.right);
            queue.add(s.left);
        }
        return true;
    }
}
