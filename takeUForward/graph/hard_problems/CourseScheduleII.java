package takeUForward.graph.hard_problems;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int N, int[][] arr) {
        List<Integer>[] G = new ArrayList[N];
        for ( int i=0; i<N; i++) G[i] = new ArrayList<>();
        for ( int[] edge: arr){
            G[edge[1]].add(edge[0]);
        }

        int[] indegree = new int[N];
        for ( int i=0; i<N; i++){
            for ( int adjNode: G[i]){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<N; i++)  if ( indegree[i] == 0) queue.offer(i);

       int[] res = new int[N];
       int idx = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            res[idx++] = node;

            for ( int adj: G[node]){
                indegree[adj]--;
                if ( indegree[adj] == 0) queue.offer(adj);
            }
        }

       if ( idx != N) return new int[0];
        return res;
    }
}
