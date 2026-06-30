package company.microsoft;

import java.util.*;

public class BottomViewOfBT {
    public List<Integer> bottomView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while ( !queue.isEmpty()){
            Pair cur = queue.poll();
            map.put(cur.horizontalDistance, cur.node.val);
            if ( cur.node.left != null) queue.offer(new Pair(cur.node.left, cur.horizontalDistance-1));
            if ( cur.node.right != null) queue.offer(new Pair(cur.node.right, cur.horizontalDistance+1));
        }
        List<Integer> ans = new ArrayList<>(map.values());
        return ans;
    }

    class Pair{
        TreeNode node;
        int horizontalDistance;

        Pair(TreeNode node, int horizontalDistance){
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }
}
