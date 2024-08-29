package takeUForward.graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        List<Integer>[] G = new ArrayList[n];
        for ( int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for ( ArrayList<Integer> edge : prerequisites){
            G[edge.get(1)].add(edge.get(0));
            indegree[edge.get(0)]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for ( int i=0; i<n; i++){
            if ( indegree[i] == 0) q.offer(i);
        }
        int [] res = new int[n];
        int index = 0;
        while ( !q.isEmpty()){
            int node = q.poll();
            res[index++] = node;
            for ( int adjNode: G[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) q.offer(adjNode);
            }
        }
        return index == n ? res: new int[]{};
    }
}
