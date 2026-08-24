package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G17DetectACycleInADirectedGraph {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        return isCyclicBFS(N, adj);
    }

    private boolean isCyclicBFS(int n, List<List<Integer>> adj) {
        int []indegree = new int[n];
        for ( int i=0; i<n; i++){
            for ( int adjNode: adj.get(i)) indegree[adjNode]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<n; i++){
            if ( indegree[i] == 0) queue.offer(i);
        }
        List<Integer> topoSortList = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            topoSortList.add(node);
            for ( int adjNode: adj.get(node)){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return topoSortList.size() != n;
    }
}
