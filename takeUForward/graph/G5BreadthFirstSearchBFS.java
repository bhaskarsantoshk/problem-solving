package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G5BreadthFirstSearchBFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[V];
        q.offer(0);
        vis[0] = true;
        while ( !q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for ( int adjNode: adj.get(node)){
                if ( !vis[adjNode]) {
                    q.offer(adjNode);
                }
            }
        }
        return result;
    }
}
