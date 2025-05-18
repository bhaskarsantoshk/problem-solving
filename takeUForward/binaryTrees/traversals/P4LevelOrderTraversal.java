package takeUForward.binaryTrees.traversals;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P4LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(node);
        while ( !queue.isEmpty()){
            int size = queue.size();
            result.add(new ArrayList<>());
            for ( int i=0; i<size; i++){
                node = queue.poll();
                result.get(result.size()-1).add(node.val);
                if ( node.right != null) queue.offer(node.right);
                if ( node.left != null) queue.offer(node.left);
            }
        }
        return result;
    }
}
