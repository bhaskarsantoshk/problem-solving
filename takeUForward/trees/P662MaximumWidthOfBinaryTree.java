package takeUForward.trees;

import java.util.LinkedList;
import java.util.Queue;

public class P662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if ( root == null) return 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()){
            max = Math.max( q.peekLast().val - q.peekFirst().val+1, max);
            int min = q.peek().val;
            int size = q.size();
            for ( int i=0; i<size; i++){
                TreeNode node = q.peek().node;
                int val = q.peek().val;
                q.poll();
                int curId = val-min;
                if ( node.left != null ){
                    q.offer(new Pair(2*curId+1, node.left));
                }
                if ( node.right != null ){
                    q.offer(new Pair(2*curId+2, node.right));
                }
            }
        }
        return max;
    }

    class Pair{
        int val;
        TreeNode node;

        public Pair(int val, TreeNode node) {
            this.val = val;
            this.node = node;
        }
    }
}
