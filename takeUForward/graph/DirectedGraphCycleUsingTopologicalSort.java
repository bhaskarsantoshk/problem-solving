package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphCycleUsingTopologicalSort {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[V];
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)){
                inDegree[adjNode]++;
            }
        }

        int count = 0;
        for (int i=0; i<V; i++){
            if ( inDegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for ( int adjNode: adj.get(node)){
                inDegree[adjNode]--;
                if ( inDegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        return V != count;
    }
}
