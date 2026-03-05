package company.apple;

import java.util.LinkedList;
import java.util.Queue;

public class P25SameTree {
    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if ( p == null || q == null) return p == null && q == null;
        return p.val == q.val && isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null || q == null) return p == null && q == null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while ( !queue.isEmpty()){
            TreeNode r = queue.poll();
            TreeNode s = queue.poll();
            if ( r == null && s == null) continue;
            if ( r == null || s == null || r.val != s.val) return false;
            queue.offer(r.left);
            queue.offer(s.left);
            queue.offer(r.right);
            queue.offer(s.right);
        }
        return true;
    }
}
