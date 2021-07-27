package data_structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReversedLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                currentLevel.add(node.data);
                if ( node.left != null ){
                    queue.offer(node.left);
                }
                if ( node.right != null ){
                    queue.offer(node.right);
                }
            }
            res.add(0, currentLevel);
        }
        return res;
    }
}
