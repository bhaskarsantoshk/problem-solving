package company.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        List<Integer>[] g = buildGraph(dict, K);
        int[] topoSort = topoSort(g, K);
        StringBuffer sb = new StringBuffer();
        for ( int i: topoSort) sb.append((char)(i+'a'));
        return sb.toString();
    }

    private int[] topoSort(List<Integer>[] g, int V) {
        int [] topo = new int[V];
        int index = 0;
        int indegree[] = new int[V];
        for ( int i=0; i<V; i++){
            for ( int adjNode: g[i]){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<V; i++) if ( indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()){
            int node = queue.poll();
            topo[index] = node;
            index++;
            for ( int adjNode: g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        return topo;
    }

    private List<Integer>[] buildGraph(String[] dict, int V) {
        List<Integer>[] g = new ArrayList[V];
        for ( int i=0; i<V; i++) g[i] = new ArrayList<>();
        for ( int i=0; i<dict.length-1; i++){
            String s = dict[i];
            String t = dict[i+1];
            for (int j=0; j<s.length() && j < t.length() ; j++){
                if ( s.charAt(j) == t.charAt(j)) continue;
                g[s.charAt(j)-'a'].add(t.charAt(j)-'a');
            }
        }
        return g;
    }
}
