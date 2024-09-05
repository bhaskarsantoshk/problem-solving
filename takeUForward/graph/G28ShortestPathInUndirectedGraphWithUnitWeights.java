package takeUForward.graph;

import java.util.*;

public class G28ShortestPathInUndirectedGraphWithUnitWeights {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<Integer>[] G = new ArrayList[n];
        for ( int i=0; i<n; i++) G[i] = new ArrayList<>();
        for ( int []edge : edges){
            G[edge[0]].add(edge[1]);
            G[edge[1]].add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int [] distance = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[src] = 0;
        q.offer(src);
        while (!q.isEmpty()){
            int node = q.poll();
            for ( int adjNode: G[node]){
                if ( distance[node]+1 < distance[adjNode]) {
                    distance[adjNode] = distance[node]+1;
                    q.offer(adjNode);
                }
            }
        }
        for ( int i=0; i<n; i++){
            if ( distance[i] == (int)1e9) distance[i] = -1;
        }
        return distance;
    }
}
