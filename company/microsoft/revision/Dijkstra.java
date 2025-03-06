package company.microsoft.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int[] distanceArray = new int[adj.size()];
        Arrays.fill(distanceArray, (int)1e9);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        distanceArray[src] = 0;
        pq.offer(new int[]{0, src}); // distance, node

        while ( !pq.isEmpty()){
            int [] pair = pq.poll();
            int distance = pair[0];
            int node = pair[1];

            for ( int i=0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if ( distance+ wt < distanceArray[adjNode]){
                    distanceArray[adjNode] = distance+wt;
                    pq.offer(new int[]{ distanceArray[adjNode], adjNode});
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for ( int dist: distanceArray){
            if(dist == (int)1e9) res.add(-1);
            else res.add(dist);
        }

        return res;

    }
}
