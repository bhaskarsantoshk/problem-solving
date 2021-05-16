package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int data;
    List<GraphNode> neighbours = new ArrayList<GraphNode>();
    GraphNode(int data){
        this.data = data;
    }
}
