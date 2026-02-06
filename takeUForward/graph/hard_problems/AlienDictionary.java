package takeUForward.graph.hard_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        List<Integer>[] G = buildGraph(dict, N, K);
        List<Integer> topoSort = topoSort(G, K);
        StringBuffer sb = new StringBuffer();
        for (int num: topoSort) sb.append((char) (num+'a'));
        return sb.toString();
    }

    private List<Integer> topoSort(List<Integer>[] g, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[k];

        for ( int i=0; i<k; i++){
            for ( int adjNode: g[i]){
                indegree[adjNode]++;
            }
        }

        for ( int i=0; i<k; i++) if(indegree[i] == 0) queue.offer(i);

        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for (int adjNode: g[node]){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return result;
    }

    private List<Integer>[] buildGraph(String[] dict, int n, int k) {
        List<Integer>[] G = new ArrayList[k];
        for ( int i=0; i<k; i++) G[i] = new ArrayList<>();
        for ( int i=0; i<n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());
            for ( int j=0; j<len; j++){
                if ( s1.charAt(j) != s2.charAt(j)){
                    G[s1.charAt(j)-'a'].add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        return G;
    }
}
