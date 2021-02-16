package company.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if ( node == null ) return null;
        if ( map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label, new ArrayList<UndirectedGraphNode>());
        map.put(node.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors){
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }


    class UndirectedGraphNode{
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode ( int _label){
            label = _label;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

        UndirectedGraphNode(){
            label = 0;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

        UndirectedGraphNode(int _label, ArrayList<UndirectedGraphNode> _neighbors){
            label = _label;
            neighbors = _neighbors;
        }
    }
}
