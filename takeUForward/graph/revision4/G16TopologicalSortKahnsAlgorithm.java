package takeUForward.graph.revision4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G16TopologicalSortKahnsAlgorithm {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int [] indegree = new int[V];
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int [] topoSort = new int[V];
        int index = 0;
        for ( int i=0; i<V; i++) if ( indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()){
            int node = queue.poll();
            topoSort[index++] = node;
            for ( int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return index == V ? topoSort: new int[]{-1};
    }
}
