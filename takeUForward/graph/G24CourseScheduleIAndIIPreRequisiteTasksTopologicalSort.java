package takeUForward.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G24CourseScheduleIAndIIPreRequisiteTasksTopologicalSort {
    public boolean isPossible(int V,int E, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[V];
        for ( int i=0; i<V; i++) G[i] = new ArrayList<>();
        int [] indegree = new int[V];
        for ( int[] prerequisite : prerequisites){
            int u = prerequisite[0];
            int v = prerequisite[1];
            G[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for ( int i=0; i<V; i++){
            if ( indegree[i] == 0) q.offer(i);
        }

        List<Integer> courseOrder = new ArrayList<>();
        while ( !q.isEmpty()){
            int node = q.poll();
            courseOrder.add(node);
            for ( int adjNode: G[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        return courseOrder.size() == V;
    }
}
