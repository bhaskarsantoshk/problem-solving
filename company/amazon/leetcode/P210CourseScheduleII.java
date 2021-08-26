package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        ArrayList<Integer>[] g = new ArrayList[numCourses];
        for ( int i = 0; i<numCourses; i++){
            g[i] = new ArrayList<>();
        }
        int[] degree = new int[numCourses];

        for ( int[] edge: prerequisites){
            g[edge[1]].add(edge[0]);
            degree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++){
            if ( degree[i] == 0){
                queue.offer(i);
            }
        }
        int completedCourses = 0;
        while ( !queue.isEmpty() ){
            int course = queue.poll();
            res[completedCourses]= course;
            completedCourses++;
            for ( int connectedCourse : g[course]){
                if ( --degree[connectedCourse] == 0){
                    queue.offer(connectedCourse);
                }
            }
        }
        return completedCourses == numCourses ? res: new int[0];
    }
}
