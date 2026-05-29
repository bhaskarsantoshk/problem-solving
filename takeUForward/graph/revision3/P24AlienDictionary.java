package takeUForward.graph.revision3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P24AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        List<Integer>[] g = buildGraph(dict, N, K);
        List<Integer> topoSort = topologicalSort(g, K);
        StringBuilder sb = new StringBuilder();
        for (int num: topoSort){
            sb.append((char)(num+'a'));
        }
        return sb.toString();
    }

    private List<Integer> topologicalSort(List<Integer>[] g, int k) {
        List<Integer> topSort = new ArrayList<>();
        int indegree[] = new int[k];
        for ( int i=0; i<k; i++){
            for ( int adjNode: g[i]) indegree[adjNode]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<k; i++) if (indegree[i]==0) queue.offer(i);

        while ( !queue.isEmpty()){
            int node = queue.poll();
            topSort.add(node);

            for ( int adjNode: g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        return topSort;

    }

    private List<Integer>[] buildGraph(String[] dict, int n, int k) {
        List<Integer>[] g = new ArrayList[k];
        for ( int i=0; i<k; i++) g[i] = new ArrayList<>();

        for ( int i=0; i<n-1; i++){
            String s = dict[i];
            String t = dict[i+1];

            int len = Math.min(s.length(), t.length());
            for ( int j=0; j<len; j++){
                if ( s.charAt(j) == t.charAt(j)) continue;
                else {
                    g[s.charAt(j)-'a'].add(t.charAt(j)-'a');
                    break;
                }
            }
        }
        return g;
    }
}
