package takeUForward.graph;

import java.util.*;

public class G22KahnSAlgorithmTopologicalSortAlgorithmBFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for ( int i=0; i<V; i++){
            for ( int j: adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for ( int i=0; i<indegree.length; i++){
            if ( indegree[i] == 0) q.offer(i);
        }
        List<Integer> topoSort = new ArrayList<>();
        while ( !q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);
            for ( int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        if (topoSort.size() != V) return new int[]{-1};
        int[] topologicalOrder = new int[V];
        for ( int i=0; i<V; i++){
            topologicalOrder[i] = topoSort.get(i);
        }
        return topologicalOrder;
    }
}
