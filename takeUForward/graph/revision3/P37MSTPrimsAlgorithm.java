package takeUForward.graph.revision3;

import java.util.List;
import java.util.PriorityQueue;

public class P37MSTPrimsAlgorithm {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.wt-b.wt);

        pq.offer(new Pair(0, 0));
        boolean[] vis = new boolean[V];
        int sum = 0;
        while (!pq.isEmpty()){
            int node = pq.peek().node;
            int weight = pq.peek().wt;
            pq.poll();
            if ( vis[node]) continue;
            vis[node] = true;
            sum += weight;
            for ( int i=0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i).get(0);
                int adjWeight = adj.get(node).get(i).get(1);

                if ( !vis[adjNode]) pq.offer(new Pair(adjNode, adjWeight));
            }
        }
        return sum;
    }

    class Pair{
        int node;
        int wt;

        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }
}
