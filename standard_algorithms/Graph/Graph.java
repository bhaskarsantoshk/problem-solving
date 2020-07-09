package standard_algorithms.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int numOfVertices;
    private LinkedList<Integer> adjacencyList[];

    public Graph(int numOfVertices){
        this.numOfVertices = numOfVertices;
        adjacencyList = new LinkedList[numOfVertices];
        for ( int i=0; i<numOfVertices; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v){
        adjacencyList[u].add(v);
    }

    public static void main(String[] args){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS: ");
        g.DFS();
        System.out.println();
        System.out.println("BFS: ");
        g.BFS(2);
        System.out.println("Connected Components");
        g.connectedComponents(4);
    }

    private void BFS(int s) {
        boolean[] visited = new boolean[numOfVertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0){
            int v = queue.poll();
            System.out.print(v+" ");
            Iterator<Integer> itr = adjacencyList[v].listIterator();
            while (itr.hasNext()){
                int neighbour = itr.next();
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    private void DFS() {
        boolean visited[] = new boolean[numOfVertices];
        for ( int i=0; i<numOfVertices; i++) {
            if(!visited[i]) DFSUtil(i, visited);
        }
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> itr = adjacencyList[v].listIterator();
        while (itr.hasNext()){
            int neighbour = itr.next();
            if (!visited[neighbour]){
                DFSUtil(neighbour, visited);
            }
        }
    }
    
     public void connectedComponents(int numOfVertices){
        boolean[] visited = new boolean[numOfVertices];
        int count = 0;
        for ( int v=0; v<numOfVertices; v++){
            if (!visited[v]){
                count++;
                DFSUtil(v, visited);
                System.out.println();
            }
        }
        System.out.println(count);
    }
}
