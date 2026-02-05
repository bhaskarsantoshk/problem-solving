package takeUForward.graph.hard_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {
    public boolean canFinish(int N, int[][] arr) {
        List<Integer>[] G = new ArrayList[N];
        for ( int i=0; i<N; i++) G[i] = new ArrayList<>();
        for ( int[] edge: arr){
            G[edge[0]].add(edge[1]);
        }

        int[] indegree = new int[N];
        for ( int i=0; i<N; i++){
            for ( int adjNode: G[i]){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<N; i++)  if ( indegree[i] == 0) queue.offer(i);

        List<Integer> topoSort = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);

            for ( int adj: G[node]){
                indegree[adj]--;
                if ( indegree[adj] == 0) queue.offer(adj);
            }
        }
        return topoSort.size() == N;
    }
}
