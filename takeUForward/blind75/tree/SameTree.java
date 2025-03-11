package takeUForward.blind75.tree;

import company.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null || q == null ) return p == null && q == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if ( p == null || q == null) return p == null && q == null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while ( !queue.isEmpty() ){
            TreeNode s = queue.poll();
            TreeNode t = queue.poll();
            if ( s== null && t == null) continue;
            if ( s == null || t == null || s.val != t.val) return false;
            queue.offer(s.left);
            queue.offer(t.left);
            queue.offer(s.right);
            queue.offer(t.right);
        }
        return true;
    }
}
