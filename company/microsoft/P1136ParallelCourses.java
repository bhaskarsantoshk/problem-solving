package company.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1136ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] g = new ArrayList[n];
        for ( int i=0; i<n; i++) g[i] = new ArrayList<>();
        int indegree[] = new int[n];
        for ( int [] edge: relations){
            int u = edge[0], v = edge[1];
            g[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int parallel=0;
        for ( int i=1; i<=n; i++) if ( indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()){
            Queue<Integer> nextLevel = new LinkedList<>();
            int size = queue.size();
            for ( int i=0; i<size; i++) {
                int node = queue.poll();
                for ( int adjNode: g[node]){
                    indegree[adjNode]--;
                    if ( indegree[adjNode] == 0) nextLevel.offer(adjNode);
                }
            }
            parallel++;
            queue = nextLevel;
        }

        return parallel != 0 ? parallel:-1;
    }
}
