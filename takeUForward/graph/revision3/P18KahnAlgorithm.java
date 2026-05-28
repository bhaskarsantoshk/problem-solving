package takeUForward.graph.revision3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P18KahnAlgorithm {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)){
                indegree[adjNode]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<V; i++){
            if ( indegree[i] == 0) queue.offer(i);
        }

        int[] topSort = new int[V];
        int i=0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            topSort[i++] = node;
            for ( int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }
        return topSort;
    }
}
