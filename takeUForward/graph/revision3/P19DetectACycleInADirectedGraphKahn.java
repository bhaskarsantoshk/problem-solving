package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P19DetectACycleInADirectedGraphKahn {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        return topoSort(N, adj).size() != N;
    }

    public List<Integer> topoSort(int V, List<List<Integer>> adj) {
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

        List<Integer> topSort = new ArrayList<>();
        int i=0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            topSort.add(node);
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
