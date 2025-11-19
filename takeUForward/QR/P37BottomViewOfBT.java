package takeUForward.QR;

import java.util.*;

public class P37BottomViewOfBT {
    public List<Integer> bottomView(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Tuple(0, root));
        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.treeNode;
            map.put(tuple.verticle, node.data);
            if ( node.left != null) queue.offer(new Tuple(tuple.verticle-1, node.left));
            if ( node.right != null) queue.offer(new Tuple(tuple.verticle+1, node.right));
        }
        return new ArrayList<>(map.values());
    }

    class Tuple{
        int verticle;
        TreeNode treeNode;

        public Tuple(int verticle, TreeNode node) {
            this.verticle = verticle;
            this.treeNode = node;
        }
    }
}
