package company.google.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses];
        if ( numCourses == 0 || prerequisites == null || prerequisites.length == 0) return res;
        List<Integer>[] G = new ArrayList[numCourses];
        for ( int i=0; i<numCourses ; i++) G[i] = new ArrayList<>();
        int [] indegree = new int[numCourses];
        for ( int[] edge : prerequisites){
            G[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i< numCourses; i++){
            if ( indegree[i] == 0) queue.offer(i);
        }
        int index = 0;
        while ( !queue.isEmpty()){
            int standaloneCourse = queue.poll();
            res[index++] = standaloneCourse;
            for ( int course : G[standaloneCourse]){
                if ( --indegree[course] == 0) queue.offer(course);
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
