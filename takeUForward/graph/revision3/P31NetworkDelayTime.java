package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P31NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] g = new ArrayList[n+1];
        for ( int i=0; i<=n; i++) g[i] = new ArrayList<>();
        for ( int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            g[u].add(new int[]{v, wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        distance[k] = 0;
        pq.offer(new int[]{0, k});

        while ( !pq.isEmpty()){
            int [] nodeArr = pq.poll();
            int node = nodeArr[1];

            for ( int adj[] : g[node]){
                int adjNode = adj[0];
                int cost = adj[1];
                if ( distance[adjNode] > distance[node] + cost){
                    distance[adjNode] = distance[node] + cost;
                    pq.offer(new int[]{distance[adjNode], adjNode});
                }
            }
        }

        int ans = 0;
        for ( int i=1; i<=n; i++){
            if ( distance[i] == (int)1e9) return -1;
            else ans = Math.max(ans, distance[i]);
        }
        return ans;
    }
}
