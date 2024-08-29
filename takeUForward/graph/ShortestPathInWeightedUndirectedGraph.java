package takeUForward.graph;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<int[]>[] G = new ArrayList[n+1];
        for ( int i=0; i<=n; i++){
            G[i] = new ArrayList<>();
        }
        for (int [] edge: edges){
            G[edge[0]].add(new int[]{edge[1], edge[2]});
            G[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int distance[] = new int[n+1];
        int parent[] = new int[n+1];
        for ( int i=1; i<=n; i++){
            distance[i] = (int)1e9;
            parent[i] = i;
        }
        distance[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0, 1});
        while ( !pq.isEmpty()){
            int[] pair = pq.poll();
            int dist = pair[0];
            int node = pair[1];

            for ( int [] adj: G[node]  ){
                int adjNode = adj[0];
                int wt = adj[1];

                if ( dist + wt < distance[adjNode]){
                    distance[adjNode] = dist+wt;
                    pq.offer(new int[]{distance[adjNode], adjNode});
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (distance[n] == (int)1e9) {
            path.add(-1);
            return path;
        }

        int node =n;

        while ( parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        path.add(distance[n]);
        Collections.reverse(path);
        return path;
    }
}
