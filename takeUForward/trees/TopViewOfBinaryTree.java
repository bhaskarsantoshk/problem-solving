package takeUForward.trees;

import java.util.*;

public class TopViewOfBinaryTree {
    static ArrayList<Integer> topView(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Tuple(root, 0));
        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            if ( !map.containsKey(tuple.verticle)) map.put(tuple.verticle, tuple.node.val);
            if ( tuple.node.left != null ) queue.offer(new Tuple(tuple.node.left, tuple.verticle-1));
            if ( tuple.node.right != null ) queue.offer(new Tuple(tuple.node.right, tuple.verticle+1));
        }
        return new ArrayList<>(map.values());
    }

    static class Tuple{
        TreeNode node;
        int verticle;

        public Tuple(TreeNode node, int verticle) {
            this.node = node;
            this.verticle = verticle;
        }
    }
}
