package takeUForward.blind75.tree;

import company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            res.add(new ArrayList<>());
            int size = queue.size();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                res.get(res.size()-1).add(node.val);
                if ( node.left != null ) queue.offer(node.left);
                if ( node.right != null ) queue.offer(node.right);
            }
        }
        return res;
    }
}
