package cr.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CloneADirectGraph {
    public static void main(String[] args){
        ArrayList<Node> vertices = create_test_graph_undirected(7,18);
        print_graph(vertices.get(0));

    }

    private static void print_graph(Node root) {
        HashSet<Node> visited_nodes = new HashSet<>();
        print_graph(root, visited_nodes);
    }

    private static void print_graph(Node root, HashSet<Node> visited_nodes){
        if(root == null || visited_nodes.contains(root)){
            return;
        }
        visited_nodes.add(root);
        System.out.print(root.data+": {");
        for(Node node: root.neighbors){
            System.out.print(node.data+" ");
        }
        System.out.println("}");
        for(Node n: root.neighbors){
            print_graph(n, visited_nodes);
        }
    }

    private static ArrayList<Node> create_test_graph_undirected(int nodes_count, int edges_count) {
        ArrayList<Node> vertices = new ArrayList<>();
        for(int i=0;i<nodes_count;i++){
            vertices.add(new Node(i));
        }

        List<Pair<Integer, Integer>> all_edges = new ArrayList<>();

        for(int i=0; i<vertices.size(); i++){
            for(int j= i+1; j<vertices.size(); j++){
                all_edges.add(new Pair <Integer, Integer>(i,j));
            }
        }

        Collections.shuffle(all_edges);

        for(int i=0; i<edges_count && i<all_edges.size(); i++){
            Pair<Integer, Integer> edge = all_edges.get(i);
            vertices.get(edge.first).neighbors.add(vertices.get(edge.second));
            vertices.get(edge.second).neighbors.add(vertices.get(edge.first));
        }

        return vertices;

    }

}
