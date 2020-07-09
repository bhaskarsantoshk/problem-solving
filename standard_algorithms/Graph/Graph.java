package standard_algorithms.Graph;

import java.util.ArrayList;

public class Graph {
    public static void main(String[] args){
        int numOfVertices = 5;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(numOfVertices);

        for ( int i=0; i<numOfVertices; i++){
            adjacencyList.add(new ArrayList<Integer>());
        }

        // Adding edges one by one 
        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);

        displayGraph(adjacencyList);

    }

    private static void displayGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
        for ( int i=0; i<adjacencyList.size(); i++){
            System.out.print(i +"-> ");
            for ( int neighbour : adjacencyList.get(i)){
                System.out.print(neighbour+", ");
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }
}
