package Recursion;

import java.util.ArrayList;

public class DFS {
    static class Graph{
        int numOfVertices;
        ArrayList<Integer>[] neighbours;

        Graph(int numOfVertices){
            this.numOfVertices = numOfVertices;
            neighbours = new ArrayList[numOfVertices];
            for ( int i=0; i<numOfVertices; i++){
                neighbours[i] = new ArrayList<>();
            }
        }

        public void dfs(int start){
            boolean[] visited = new boolean[numOfVertices];
            dfs(start, visited);
        }

        private void dfs(int start, boolean[] visited) {
            visited[start] = true;
            System.out.print(start+" ");
            for ( int i=0; i<neighbours[start].size(); i++){
                int toNode = neighbours[start].get(i);
                if ( !visited[toNode]){
                    dfs(toNode, visited);
                }
            }
        }

        public void addEdge(int from, int to) {
            neighbours[from].add(to);
        }
    }

    public static void main( String args[] ) {
        System.out.println( "Your DFS path is: " );

        int nVertices = 6;

        Graph g = new Graph(nVertices);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        // Root node given as argument to the function
        g.dfs(0);
    }
}
