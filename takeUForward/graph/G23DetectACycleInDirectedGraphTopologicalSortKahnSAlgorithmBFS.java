package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G23DetectACycleInDirectedGraphTopologicalSortKahnSAlgorithmBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       Queue<Integer> q = new LinkedList<>();
       int [] indegree = new int[V];
       for ( int i=0; i<V; i++){
           for ( int j: adj.get(i)){
               indegree[j]++;
           }
       }
       for ( int i=0; i<V; i++){
           if ( indegree[i]==0) q.offer(i);
       }

       List<Integer> result = new ArrayList<>();
       while (!q.isEmpty()){
           int node = q.poll();
           result.add(node);
           for ( int adjNode: adj.get(node)){
               indegree[adjNode]--;
               if ( indegree[adjNode] == 0) q.offer(adjNode);
           }
       }
       return result.size() != V;
    }
}
