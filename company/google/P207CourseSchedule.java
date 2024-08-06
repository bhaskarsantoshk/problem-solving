package company.google;

import java.util.ArrayList;
import java.util.List;

public class P207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[numCourses];
        for ( int i=0; i<G.length; i++) G[i] = new ArrayList<>();
        for ( int[] preReq: prerequisites){
            G[preReq[1]].add(preReq[0]);
        }
        int [] vis = new int[numCourses];
        int [] pathVis = new int[numCourses];

        for ( int i=0; i<numCourses; i++){
            if ( vis[i] == 0) {
                if ( dfs(numCourses, G, i, vis, pathVis)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int numCourses, List<Integer>[] g, int node, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;
        for ( int adjNode: g[node]){
            if ( vis[adjNode] == 0){
                if ( dfs(numCourses, g, adjNode, vis, pathVis)) return true;
            } else  if ( pathVis[adjNode] == 1) return true;
        }
        pathVis[node] = 0;
        return false;
    }
}
