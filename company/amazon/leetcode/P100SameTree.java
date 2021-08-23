package company.amazon.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class P100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null || q == null ) return p==null && q==null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public boolean isSameTreeIterative ( TreeNode p, TreeNode q){
        if ( p == null && q == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while ( !queue.isEmpty() ){
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();

            if ( f == null && s == null ){
                continue;
            } else if ( f == null || s == null || f.val != s.val ){
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }
}
