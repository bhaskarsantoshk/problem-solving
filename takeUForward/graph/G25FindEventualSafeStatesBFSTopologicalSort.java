package takeUForward.graph;

import java.util.*;

public class G25FindEventualSafeStatesBFSTopologicalSort {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int [] indegree = new int[V];
        List<List<Integer>> adjRev = new ArrayList<>();
        for ( int i=0; i<V; i++) adjRev.add(new ArrayList<>());
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj.get(i)){
                // i -> adjNode
                // need to change from adjNode -> i
                adjRev.get(adjNode).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for ( int i=0; i<V; i++){
            if ( indegree[i] == 0) {
                q.offer(i);
                res.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for ( int adjNode: adjRev.get(node)){
                if ( --indegree[adjNode] == 0) {
                    res.add(adjNode);
                    q.offer(adjNode);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
