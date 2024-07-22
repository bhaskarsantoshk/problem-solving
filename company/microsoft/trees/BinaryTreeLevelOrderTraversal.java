package company.microsoft.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import company.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty()){
            res.add(new ArrayList<>());
            int size = queue.size();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                res.get(res.size()-1).add(node.val );
                if ( node.left != null ) queue.add(node.left);
                if ( node.right != null ) queue.add(node.right);
            }
        }
        return res;
    }
}

// 1 2 3 4 5 6 7
