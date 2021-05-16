package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int numVertices;
    List<Integer>[] neighbours;
    Graph(int numVertices) {
        this.numVertices = numVertices;
        neighbours = new ArrayList[numVertices];
        for (int i = 0; i < numVertices ; i++) {
            neighbours[i] = new ArrayList<>();
        }
    }

    public void addEgde(int fromNode, int toNode) {
        neighbours[fromNode].add(toNode);
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        dfs(startVertex, visited);
    }

    private void dfs(int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        System.out.println(startVertex);
        for ( Integer neighbour : neighbours[startVertex]){
            if (!visited[neighbour]){
                dfs(neighbour, visited);
            }
        }
    }
}
