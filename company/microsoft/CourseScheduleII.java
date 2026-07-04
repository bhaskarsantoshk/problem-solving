package company.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];

        for ( int i=0; i<numCourses ; i++) g[i] = new ArrayList<>();
        int indegree[] = new int[numCourses];
        for ( int []prereq : prerequisites){
            int u = prereq[0];
            int v = prereq[1];
            g[v].add(u);
            indegree[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++) if ( indegree[i] == 0) queue.offer(i);
        int [] topSort = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            topSort[index++] = node;
            for ( int adjNode : g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        return index == numCourses ?  topSort : new int[]{};
    }
}
