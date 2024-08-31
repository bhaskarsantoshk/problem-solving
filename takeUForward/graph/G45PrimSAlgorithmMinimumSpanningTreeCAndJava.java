package takeUForward.graph;

import java.util.List;
import java.util.PriorityQueue;

public class G45PrimSAlgorithmMinimumSpanningTreeCAndJava {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,0});// wt, node ; take parent if asked to print MST
        int sum = 0;
        while ( !pq.isEmpty()){
            int[] pair = pq.poll();
            int wt = pair[0];
            int node = pair[1];
            if ( vis[node] ) continue;
            vis[node] = true;
            // add to MST here
            sum += wt;
            for ( int i=0; i<adj.get(node).size(); i++){
                int adjWt = adj.get(node).get(i)[1];
                int adjNode = adj.get(node).get(i)[0];
                if ( !vis[adjNode]){
                    pq.offer(new int[]{adjWt, adjNode});
                }
            }
        }
        return sum;
    }
}
