package express_prep.amzn.top_voted;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if ( numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true;
        }
        List<Integer>[] G = new ArrayList[numCourses];
        for ( int i=0; i<numCourses; i++){
            G[i] = new ArrayList<>();
        }
        int[] degree = new int[numCourses];
        for ( int []edge : prerequisites){
            G[edge[1]].add(edge[0]);
            degree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++){
            if ( degree[i] == 0){
                queue.offer(i);
            }
        }
        int completedCourses = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            for ( int connectedCourse : G[course]){
                if ( --degree[connectedCourse] == 0){
                    queue.offer(connectedCourse);
                }
            }
        }
        return completedCourses == numCourses;
    }
}
