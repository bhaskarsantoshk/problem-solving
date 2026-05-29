package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P20CourseScheduleII {
    public int[] findOrder(int N, int[][] arr) {
        List<Integer>[] g = new ArrayList[N];
        for ( int i=0; i<N; i++){
            g[i] = new ArrayList<>();
        }
        int []indegree = new int[N];

        // [ a, b] indicates b as pre-requisite for a, so b -> a
        for ( int [] edge: arr){
            g[edge[1]].add(edge[0]);
        }

        for ( int i=0; i<N; i++){
            for ( int adjnode: g[i]) indegree[adjnode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<N; i++) if ( indegree[i] == 0) queue.offer(i);

        int[] toposort = new int[N];
        int index = 0;

        while ( !queue.isEmpty()){
            int node = queue.poll();
            toposort[index++]= (node);

            for ( int adjNode: g[node] ){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        return (index != N ) ? new int[0]: toposort;
    }
}
