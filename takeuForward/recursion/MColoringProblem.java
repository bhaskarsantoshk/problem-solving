package takeuForward.recursion;

// https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

public class MColoringProblem {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int [] colorArray = new int[n];
        return graphColoring(graph, m, n, 0, colorArray);
    }

    private boolean graphColoring(boolean[][] graph, int m, int n, int node, int[] colorArray) {
        if ( node == n){
            return true;
        }
        for ( int color=1; color<=m; color++){
            if ( possibleToColor(graph, n, m, node, colorArray, color)){
                colorArray[node] = color;
                if ( graphColoring(graph, m, n, node+1, colorArray) ) return true;
                colorArray[node] = 0;
            }
        }
        return false;
    }

    private boolean possibleToColor(boolean[][] graph, int n, int m, int node, int[] colorArray, int color) {
        for ( int i=0; i<n; i++){
            if ( graph[node][i] && colorArray[i] == color) return false;
        }
        return true;
    }
}
