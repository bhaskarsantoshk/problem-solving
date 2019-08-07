package interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if ( A == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        int currentLevel = 1;
        int nextLevel = 0;
        int index = 0;
        result.add(new ArrayList<>());
        while ( !queue.isEmpty()){
            TreeNode node = queue.poll();
            result.get(index).add(node.val);
            currentLevel--;
            if ( node.left != null ){
                queue.offer(node.left);
                nextLevel++;
            }
            if ( node.right != null ){
                queue.offer(node.right);
                nextLevel++;
            }
            if ( currentLevel == 0){
                currentLevel = nextLevel;
                nextLevel = 0;
                result.add(new ArrayList<>());
                index++;
            }

        }
        result.remove(result.size()-1);
        return  result;
    }
}
