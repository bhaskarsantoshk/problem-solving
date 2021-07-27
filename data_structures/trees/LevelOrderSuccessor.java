package data_structures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static TreeNode findLevelOrderSuccessor(TreeNode root, int key) {
        if ( root == null ) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            int levelSize = queue.size();
            TreeNode node = queue.poll();
            if (node.left != null ) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (node.data == key){
                    break;
            }
        }
        return queue.peek();
    }
}
