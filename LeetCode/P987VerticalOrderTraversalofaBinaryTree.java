package LeetCode;

import java.util.*;

public class P987VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ){
            return result;
        }
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));
        int minHd = 0;
        int maxHd = 0;
        while ( !queue.isEmpty() ){
            Node node = queue.poll();
            map.putIfAbsent(node.hd, new ArrayList<>());
            minHd = Math.min(minHd, node.hd);
            maxHd = Math.max( maxHd, node.hd);
            map.get(node.hd).add(node);
            if ( node.root.left != null ){
                queue.offer(new Node(node.root.left, node.hd-1, node.vd-1));
            }
            if ( node.root.right != null ){
                queue.offer(new Node(node.root.right, node.hd+1, node.vd-1));
            }
        }
        int index = 0;
        for(int i=minHd; i<= maxHd; i++){
            Collections.sort(map.get(i), (a,b)-> {
                if ( a.vd == b.vd ){
                    return a.root.val - b.root.val;
                }
                else{
                    return b.vd - a.vd;
                }
            });
            result.add(new ArrayList<>());
            for(Node node: map.get(i)){
                result.get(index).add(node.root.val);
            }
            index++;
        }

        return result;
    }

    class Node{
        TreeNode root;
        int hd;
        int vd;

        public Node(TreeNode root, int hd, int vd){
            this.root = root;
            this.hd = hd;
            this.vd = vd;
        }
    }
}
