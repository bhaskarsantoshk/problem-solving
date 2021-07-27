package data_structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesInABinaryTree {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if ( root == null ) return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int levelSum = 0;
            for ( int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                levelSum+= node.data;
                if ( node.left != null ){
                    queue.offer(node.left);
                }
                if ( node.right != null ){
                    queue.offer(node.right);
                }
            }
            result.add((double) (levelSum/levelSize));
        }
        return result;
    }
}
