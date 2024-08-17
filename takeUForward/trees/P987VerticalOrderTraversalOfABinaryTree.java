package takeUForward.trees;

import java.util.*;

public class P987VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ){
            return result;
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        while ( !queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int verticle = tuple.col;
            int level = tuple.row;

            if ( !map.containsKey(verticle)){
                map.put(verticle, new TreeMap<>());
            }
            if (!map.get(verticle).containsKey(level)){
                map.get(verticle).put(level, new PriorityQueue<>());
            }
            map.get(verticle).get(level).add(node.val);
            if ( node.left != null ) queue.offer(new Tuple(node.left, level+1, verticle-1));
            if ( node.right != null ) queue.offer(new Tuple(node.right, level+1, verticle+1));
        }

        for ( TreeMap<Integer, PriorityQueue<Integer>> eachVerticle: map.values() ){
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : eachVerticle.values()){
                while ( !nodes.isEmpty()){
                    result.get(result.size()-1).add(nodes.poll());
                }
            }
        }
        return result;
    }

    class Tuple{
        TreeNode node;
        int row, col;

        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
