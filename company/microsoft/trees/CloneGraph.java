package company.microsoft.trees;

import java.util.*;

public class CloneGraph {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node){
        if ( node == null) return node;
        if ( map.containsKey(node.val)) return map.get(node.val);
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        for ( Node neighbor: node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

    Map<Node, Node> vis = new HashMap<>();
    public Node cloneGraphBFS(Node node){
        if ( node == null ) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        vis.put(node, new Node(node.val, new ArrayList<>()));
        while ( !queue.isEmpty() ){
            Node n = queue.poll();
            for ( Node neighbor: n.neighbors){
                if ( !vis.containsKey(neighbor)) {
                    vis.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                vis.get(n).neighbors.add(vis.get(neighbor));
            }
        }
        return vis.get(node);
    }

    class Node {
        int val;
        List<Node> neighbors;

        Node(){
            val=0;
            neighbors= new ArrayList<>();
        }
        Node(int val){
            val = val;
            neighbors = new ArrayList<>();
        }

        Node ( int val, List<Node> neighbors){
            val = val;
            neighbors = neighbors;
        }

    }
}
