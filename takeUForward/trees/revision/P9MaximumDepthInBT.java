package takeUForward.binaryTrees;

import takeUForward.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P1MaximumDepthInBT {
    public int maxDepth(TreeNode root) {
        if ( root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return 1+Math.max(lh, rh);
    }

    public int maxDepthIterative( TreeNode root) {
        if ( root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty()){
            int size = queue.size();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if ( node.left != null) queue.offer(node.left);
                if ( node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return level;
    }
}
