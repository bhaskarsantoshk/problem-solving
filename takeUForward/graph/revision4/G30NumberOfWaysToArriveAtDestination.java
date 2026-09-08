package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G30NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, List<List<Integer>> roads) {
        List<int[]>[] graph = new ArrayList[n];
        for ( int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for ( List<Integer> road : roads){
            int u = road.get(0);
            int v = road.get(1);
            int wt = road.get(2);
            graph[u].add(new int[]{v, wt});
            graph[v].add(new int[]{u, wt});
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int[] ways = new int[n];
        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Math.toIntExact(a[0] - b[0]));
        pq.offer(new long[]{0,0});

        int mod = (int)1e9+7;

        while (!pq.isEmpty()){
            long[] nodeArr = pq.poll();

            int node = (int)nodeArr[1];
            long dist = nodeArr[0];
            if ( dist > distance[node] ) continue;

            for ( int[] adjArr: graph[node]){
                int adjNode = adjArr[0];
                int wt = adjArr[1];

                if ( distance[adjNode] > distance[node] + wt){
                    distance[adjNode] = distance[node] + wt;
                    pq.offer(new long[]{ distance[adjNode], adjNode});
                    ways[adjNode] = ways[node];
                } else if ( distance[adjNode] == distance[node] + wt ){
                    ways[adjNode] = (ways[node]+ways[adjNode])%mod;
                }
            }
        }

        return ways[n-1] % mod;

    }
}
