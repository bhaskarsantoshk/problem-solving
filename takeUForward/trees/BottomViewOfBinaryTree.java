package takeUForward.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(TreeNode root)
    {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Tuple(0, root));
        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int verticle = tuple.verticle;
            map.put(verticle, node.val);
            if ( node.left != null) queue.offer(new Tuple(verticle-1, node.left));
            if ( node.right != null) queue.offer(new Tuple(verticle+1, node.right));
        }
        return new ArrayList<>(map.values());
    }

    class Tuple{
        int verticle;
        TreeNode node;

        public Tuple(int verticle, TreeNode node) {
            this.verticle = verticle;
            this.node = node;
        }
    }
}
