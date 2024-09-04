package takeUForward.graph;
import java.util.*;

public class P133CloneGraph {
    Map<Node, Node> vis = new HashMap<>();
    public Node cloneGraph(Node node) {
        if ( node == null ) return node;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        vis.put(node, new Node(node.val, new ArrayList<>()));

        while ( !q.isEmpty()){
            Node current = q.poll();
            for( Node adjNode: current.neighbors){
                if ( !vis.containsKey(adjNode)){
                    q.offer(adjNode);
                    vis.put(adjNode, new Node(adjNode.val, new ArrayList<>()));
                }
                vis.get(current).neighbors.add(vis.get(adjNode));
            }
        }
        return vis.get(node);
    }

    class Node{
        int val;
        List<Node> neighbors;

        Node(){
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        Node(int val, List<Node> neighbours){
            this.val = val;
            this.neighbors = neighbours;
        }

    }
}
