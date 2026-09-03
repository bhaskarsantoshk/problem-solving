package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G29NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n+1];
        for ( int i=1; i<=n; i++) graph[i] = new ArrayList<>();
        for (int[] edge: times){
            int u = edge[0], v = edge[1], wt = edge[2];
            graph[u].add(new int[]{v, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        distance[k] = 0;
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()){
            int [] nodeArr = pq.poll();
            int node = nodeArr[0];
            int wt = nodeArr[1];
            if (wt > distance[node]) continue;
            for ( int [] adjArr: graph[node]){
                int adjNode = adjArr[0];
                int edgeWt = adjArr[1];
                if ( distance[adjNode] > distance[node] + edgeWt) {
                    distance[adjNode] = distance[node]+edgeWt;
                    pq.offer(new int[]{adjNode, distance[adjNode] });
                }
            }
        }

        int max = 0;

        for (int i=1; i<=n; i++){
            if ( distance[i] == (int)1e9) return -1;
            else max = Math.max(max, distance[i]);
        }

        return max;
    }
}
