package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G19CourseScheduleII {
    public int[] findOrder(int N, int[][] arr) {
        int []indegree = new int[N];
        List<Integer>[] g = new ArrayList[N];
        for ( int i=0; i<N; i++) g[i] = new ArrayList<>();
        for ( int []prereq: arr){
            int v = prereq[0], u = prereq[1];
            indegree[v]++;
            g[u].add(v);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<N; i++){
            if ( indegree[i] == 0) queue.offer(i);
        }

        int[] courseOrder = new int[N];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            courseOrder[index++] = node;
            for (int adjNode : g[node]) {
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return index == N ? courseOrder : new int[0];
    }
}
