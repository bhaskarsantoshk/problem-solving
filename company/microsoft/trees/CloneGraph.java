package company.microsoft.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
