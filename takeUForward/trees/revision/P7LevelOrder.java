package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P7LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if ( node.left != null) queue.offer(node.left);
                if ( node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            res.add(subList);
        }
        return res;
    }
}
