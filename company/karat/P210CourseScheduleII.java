package company.karat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for ( int i=0; i<numCourses; i++) G[i] = new ArrayList<>();
        for ( int []edge: prerequisites){
            G[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for ( int i=0; i<numCourses; i++){
            if ( inDegree[i] == 0) q.offer(i);
        }
        int [] topSort = new int[numCourses];
        int index = 0;
        while ( !q.isEmpty()){
            int course = q.poll();
            topSort[index++] = course;
            for ( int connectedCourse: G[course]){
                inDegree[connectedCourse]--;
                if ( inDegree[connectedCourse] == 0) q.offer(connectedCourse);
            }
        }
        return index == numCourses ? topSort: new int[0];
    }
}
