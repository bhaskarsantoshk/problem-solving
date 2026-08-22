package takeUForward.graph.revision;

import company.microsoft.PreorderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G6CycleDetectionInUndirectedGraphBfs {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for ( int i=0; i<V; i++) if (!vis[i]) {
            if (isCycleBFS(i, adj, vis)) return true;
        }
        return false;
    }

    private boolean isCycleBFS(int node, List<Integer>[] adj, boolean[] vis) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, -1});
        vis[node] = true;
        while (!queue.isEmpty()){
            int []nodeArr = queue.poll();
            node = nodeArr[0];
            int parent = nodeArr[1];

            for ( int adjNode: adj[node]){
                if (!vis[adjNode]){
                    vis[adjNode] = true;
                    queue.offer(new int[]{adjNode, node});
                }
                else if ( adjNode != parent) return true;
            }
        }
        return false;
    }

}
