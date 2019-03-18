package cr.graphs;

import java.util.HashMap;

public class Graph {
    public static Node clone(Node root){
        HashMap<Node, Node> nodes_completed = new HashMap<>();
        return  clone_rec(root, nodes_completed);
    }

    private static Node clone_rec(Node root, HashMap<Node, Node> nodes_completed) {
        if( root == null ){
            return null;
        }
        Node pNew = new Node(root.data);
        nodes_completed.put(root, pNew);

        for(Node p: root.neighbors){
            Node x = nodes_completed.get(p);
            if(x == null){
                pNew.neighbors.add(clone_rec(p, nodes_completed));
            }
            else{
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }
}
