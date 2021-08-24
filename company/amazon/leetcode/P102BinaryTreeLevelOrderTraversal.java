package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for ( int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if ( node.left != null ) queue.offer(node.left);
                if ( node.right != null ) queue.offer(node.right);
            }
            res.add(subList);
        }
        return res;
    }
}
