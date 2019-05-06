package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root ==  null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0; i<level; i++){
                TreeNode node = queue.poll();
                if(node.left != null ){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                subList.add(node.val);
            }
            result.add(subList);
        }
        return result;
    }
}
