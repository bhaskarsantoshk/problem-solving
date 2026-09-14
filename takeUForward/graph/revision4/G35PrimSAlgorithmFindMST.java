package takeUForward.graph.revision4;

import java.util.List;
import java.util.PriorityQueue;

public class G35PrimSAlgorithmFindMST {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]); // wt, node, parent
        int mstWt = 0;

        pq.offer(new int[]{0,0, -1});

        while (!pq.isEmpty()){
            int nodeArr[] = pq.poll();
            int wt = nodeArr[0];
            int node = nodeArr[1];
            int parent = nodeArr[2];
            if ( vis[node] ) continue;
            vis[node] = true;
            mstWt += wt;
            // you can add parent - node as edge if MST is needed
            // if (parent != -1) mst.add(new int[]{parent, node, wt});
            for ( int i=0; i< adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i).get(0);
                int adjWt = adj.get(node).get(i).get(1);
                if ( !vis[adjNode]) pq.offer(new int[]{adjWt, adjNode, node});
            }
        }

        for (int i=0; i<V; i++) if (!vis[i]) return -1;

        return mstWt;
    }
}
