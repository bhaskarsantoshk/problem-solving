package takeUForward.trees.revision2;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if ( node.left != null) queue.offer(node.left);
                if ( node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
