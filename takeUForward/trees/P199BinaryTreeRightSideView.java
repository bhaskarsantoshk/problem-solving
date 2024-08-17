package takeUForward.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199BinaryTreeRightSideView {
    // T:O(N), S: O(N)
    public List<Integer> rightSideView(TreeNode root) {
        // last node of every level
        List<Integer> res= new ArrayList<>();
        if ( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if ( i == size-1) res.add(node.val);
                if ( node.left != null) queue.offer(node.left);
                if ( node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    // T:O(N), S: O(h)
    public List<Integer> rightSideViewRecursive(TreeNode root) {
        // use pre-order
        List<Integer> res = new ArrayList<>();
        preOrder(root, 0, res);
        return res;
    }

    private void preOrder(TreeNode root, int level, List<Integer> res) {
        if ( root == null ) return;
        if ( level == res.size()) res.add(root.val);
        preOrder(root.right, level+1, res);
        preOrder(root.left, level+1, res);
    }
}
