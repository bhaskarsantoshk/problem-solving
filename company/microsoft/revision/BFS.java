package company.microsoft.revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] vis = new boolean[V];

        ArrayList<Integer> bfs = new ArrayList<>();
        queue.offer(0);
        vis[0] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            bfs.add(node);
            for ( int adjNode : adj.get(node)){
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
        return bfs;
    }
}
