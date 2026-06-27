package company.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        List<Integer>[] g = buildGraph(dict, N, K);
        List<Integer> topoSort = topoSort(g, K);
        StringBuffer sb = new StringBuffer();
        for ( int num: topoSort) sb.append((char)(num+'a'));
        return sb.toString();
    }

    private List<Integer> topoSort(List<Integer>[] g, int k) {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[k];
        for ( int i=0; i<k; i++){
            for ( int adjNode: g[i]) indegree[adjNode]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<k; i++) if ( indegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for ( int adjNode: g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return ans;
    }

    private List<Integer>[] buildGraph(String[] dict, int n, int k) {
        List<Integer>[] g = new ArrayList[k];
        for ( int i=0; i<k; i++) g[i]= new ArrayList<>();
        for ( int i=0; i<dict.length-1; i++){
            String s = dict[i];
            String t = dict[i+1];
            for ( int j=0; j < Math.min(s.length(), t.length()); j++){
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
