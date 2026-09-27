package takeUForward.graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimalSpanningTree {

    // Prim's Algorithm - think like growing the network and connecting different components than just connecting vertex
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{0,0}); // also add -1 ( parent ) if we need to print the mst
        boolean[] vis = new boolean[V];

        int mstWt = 0;

        while (!pq.isEmpty()){
            int []nodeArr = pq.poll();
            int node = nodeArr[0];
            int wt = nodeArr[1];
            if ( vis[node] ) continue;
            vis[node] = true;
            mstWt += wt; // print parent - node ( if we have to print mst )
            for (List<Integer> adjNodeArr: adj.get(node)){
                    int adjNode = adjNodeArr.get(0);
                    int adjWt = adjNodeArr.get(1);
                    if (!vis[adjNode]) pq.offer(new int[]{adjNode, adjWt});
            }
        }
        for (int i=0; i<V; i++) if (!vis[i]) return -1;
        return mstWt;
    }
}
