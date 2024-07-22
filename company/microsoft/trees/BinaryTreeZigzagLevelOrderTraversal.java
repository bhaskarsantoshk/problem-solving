package company.microsoft.trees;

import company.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    // Using Queue - classic Level Order algo
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) return res;
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while ( !queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if ( !leftToRight ) Collections.reverse(res.get(level));
            level++;
            leftToRight = !leftToRight;
        }
        return res;
    }

    // Using Deque
    public List<List<Integer>> zigzagLevelOrderUsingDeque(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null ) return res;
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            int size = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if ( leftToRight ){
                    levelList.addFirst(node.val);
                } else {
                    levelList.addLast(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add( new ArrayList<>(levelList));
            leftToRight = !leftToRight;
        }
        return res;
    }
}
