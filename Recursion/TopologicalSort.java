package Recursion;

public class TopologicalSort {
    public static void main(String[] args){
        System.out.println( "Path after Topological Sorting: " );

        int nVertices = 5;

        Graph g = new Graph(nVertices);

        g.addEgde(0, 1);
        g.addEgde(0, 4);
        g.addEgde(1, 2);
        g.addEgde(1, 3);
        g.addEgde(2, 3);
        g.addEgde(2, 4);

        // Topological function called here
        g.topologicalSorting();
    }
}
