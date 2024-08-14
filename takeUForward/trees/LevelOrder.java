package takeUForward.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    // T, S -> O(N)
    public List<List<Integer>> levelOrder(TreeNode root){
        if ( root == null ) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if ( node.left != null ) queue.offer(node.left);
                if ( node.right != null ) queue.offer(node.right);
            }
            result.add(new ArrayList<>(level));
        }
        return result;
    }
}
