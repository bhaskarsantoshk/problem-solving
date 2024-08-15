package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://bit.ly/3bn84K8

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];

        queue.offer(0);
        vis[0] = true;

        while ( !queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);
            for ( int neighbour: adj.get(node)){
                if ( !vis[neighbour]) {
                    queue.offer(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return bfs;
    }
}
