package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrerequisiteTasks {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        List<Integer>[] G = new ArrayList[N];
        for ( int i=0; i<N; i++){
            G[i] = new ArrayList<>();
        }

        for ( int[] prerequisite: prerequisites ){
            int u = prerequisite[0];
            int v = prerequisite[1];
            G[v].add(u);
        }
        int []indegree = new int[N];
        for ( int i=0; i<N; i++){
            for ( int adjNode: G[i]) indegree[adjNode]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for ( int i=0; i<N; i++){
            if ( indegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while ( !q.isEmpty() ){
            int node = q.poll();
            count++;
            for ( int adjNode: G[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        return count == N;
    }
}
