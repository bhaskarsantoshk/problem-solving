package takeUForward.graph;

import java.util.*;

public class DijkstraAlgorithmUsingSet {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Pair> set = new TreeSet<>((a, b)-> a.distance == b.distance ? a.node-b.node : a.distance-b.distance);
        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);
        distance[S] = 0;
        set.add(new Pair(0, S));
        while ( !set.isEmpty()){
            Pair pair = set.pollFirst();
            int node = pair.node;
            int dist = pair.distance;

            for ( int i=0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i).get(0);
                int wt = adj.get(node).get(i).get(1);

                if ( dist + wt < distance[adjNode]){
                    if ( distance[adjNode] != (int)1e9) set.remove(new Pair(distance[adjNode], adjNode));
                    distance[adjNode] = dist+wt;
                    set.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }

    static class Pair{
        int distance, node;

        Pair(int distance, int node){
            this.node = node;
            this.distance = distance;
        }
    }
}
