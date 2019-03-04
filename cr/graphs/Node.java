package cr.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<Node>();
    public Node(int d){
        this.data = d;
    }

}
