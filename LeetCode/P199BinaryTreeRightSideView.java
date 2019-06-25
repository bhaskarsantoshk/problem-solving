package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            int level_size = queue.size();
            for(int i=0; i< level_size; i++){
                TreeNode node = queue.poll();
                if ( i == 0){
                    result.add(node.val);
                }
                if ( node.right != null ){
                    queue.offer(node.right);
                }
                if ( node.left != null ){
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }
}
