package takeUForward.graph.revision2;

import java.util.*;

public class P15FindEventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for ( int i=0; i<V; i++){
            if (!vis[i]) dfsCycleCheck(i, vis, pathVis, check, adj);
        }
        int len = 0;
        for ( int i=0; i<V; i++) {
            if ( check[i] ) len++;
        }
        int [] ans = new int[len];
        int index = 0;
        for ( int i=0; i<V; i++){
            if ( check[i] ){
                ans[index++] = i;
            }
        }
        Arrays.sort(ans);
        return ans;
    }

    private boolean dfsCycleCheck(int node, boolean[] vis, boolean[] pathVis, boolean[] check, int[][] adj) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        for ( int adjNode: adj[node]){
            if ( !vis[adjNode]) {
                if ( dfsCycleCheck(adjNode, vis, pathVis, check, adj) ) return true;
            } else if ( pathVis[adjNode]) return true;
        }

        pathVis[node] = false;
        check[node] = true;
        return false;
    }

    public int[] eventualSafeNodesBFS(int V, int[][] adj) {
        List<Set<Integer>> adjacencyList = new ArrayList<>();
        for ( int i=0; i<V; i++) adjacencyList.add(new HashSet<>());
        int[] inDegree = new int[V];
        for ( int i=0; i<V; i++){
            for ( int adjNode: adj[i]){
                adjacencyList.get(adjNode).add(i);
                inDegree[i]++;
            }
        }
        boolean[] vis = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<V; i++) {
            if ( inDegree[i] == 0) queue.offer(i);
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);
            for ( int adjNode: adjacencyList.get(node)){
                inDegree[adjNode]--;
                if ( inDegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        int [] ans = new int[list.size()];
        for ( int i=0; i<ans.length; i++){
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
}
