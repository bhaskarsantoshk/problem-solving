package takeUForward.graph.revision2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P16CourseScheduleI {
    public boolean canFinish(int N, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[N];
        int inDegree[] = new int[N];
        for (int i = 0; i < N; i++) { G[i] = new ArrayList<>();}
        for ( int [] uv : prerequisites){
            int u = uv[0];
            int v = uv[1];
            G[u].add(v);
            inDegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> topoSort = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);
            for (int adjNode : G[node]) {
                if (--inDegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
        return topoSort.size() == N;
    }
}
