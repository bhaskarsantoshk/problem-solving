package takeUForward.graph.revision4;

import java.util.*;

public class G21FindEventualSafeStatesBFS {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        int [] indegree = new int[V];

        for ( int i=0; i<adj.length; i++){
            for ( int j=0; j < adj[i].length; j++){
                g[adj[i][j]].add(i);
                indegree[i]++;
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for ( int i=0; i < V; i++){
            if ( indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            for ( int adjNode: g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes.stream().mapToInt(Integer::intValue).toArray();
    }
}
