package company.karat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> G = new ArrayList<>();
        for ( int i=0; i<numCourses; i++) G.add(new ArrayList<>());
        int [] inDegree = new int[numCourses];
        for ( int i=0; i<prerequisites.length; i++){
            G.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++) if ( inDegree[i] == 0) queue.offer(i);
        List<Integer> topoSort = new ArrayList<>();
        while ( !queue.isEmpty()){
            int course = queue.poll();
            topoSort.add(course);
            for ( int connectedCourse: G.get(course)){
                inDegree[connectedCourse]--;
                if ( inDegree[connectedCourse] == 0) queue.offer(connectedCourse);
            }
        }
        return topoSort.size()== numCourses;
    }
}
