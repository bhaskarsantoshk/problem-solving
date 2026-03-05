package company.apple;

import java.util.*;

public class P27CloneGraph {

    class Node{
        int val;
        List<Node> neighbors;

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }

        public Node() {
        }

    }

    Map<Node, Node> vis = new HashMap<>();

    public Node cloneGraph(Node node) {
        if ( node == null) return node;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        vis.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()){
            Node current = queue.poll();
            for ( Node adjNode : current.neighbors){
                if ( !vis.containsKey(adjNode)){
                    queue.offer(adjNode);
                    vis.put(adjNode, new Node(adjNode.val, new ArrayList<>()));
                }
                vis.get(current).neighbors.add(vis.get(adjNode));
            }
        }
        return vis.get(node);
    }
}
