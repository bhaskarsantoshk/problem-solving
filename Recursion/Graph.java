package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public void topologicalSorting() {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        for ( int i=0; i<numVertices; i++){
            if (!visited[i]){
                topologicalSorting(i, visited, stack);
            }
        }
        System.out.println("Topo sort: ");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private void topologicalSorting(int start, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;
        for (int neighbour: neighbours[start]){
            if (!visited[neighbour]){
                topologicalSorting(neighbour, visited, stack);
            }
        }
        stack.push(start);
    }
}
