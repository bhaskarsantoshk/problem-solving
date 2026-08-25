package takeUForward.graph.revision4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G22AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        List<Integer>[] g = new ArrayList[K];
        for ( int i=0; i<K; i++) g[i] = new ArrayList<>();
        for ( int i=0; i<dict.length-1; i++){
            String first = dict[i];
            String second = dict[i+1];

            for ( int j=0; j<Math.min(first.length(), second.length()); j++){
                char c = first.charAt(j), d = second.charAt(j);
                if ( c == d) continue;
                else {
                    g[c-'a'].add(d-'a');
                    break;
                }
            }
        }
        List<Integer> topoSort = topoSort(g, K);
        char[] res = new char[topoSort.size()];
        for ( int i=0; i< topoSort.size(); i++){
            res[i] = (char) ('a' + topoSort.get(i));
        }
        return new String(res);
    }

    private List<Integer> topoSort(List<Integer>[] g, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int indegree[] = new int[k];
        for ( int i=0; i<k ;i++){
            for ( int adjNode: g[i]) indegree[adjNode]++;
        }
        for ( int i=0; i<k ;i++){
            if (indegree[i] == 0) queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for ( int adjNode: g[node]){
                indegree[adjNode]--;
                if ( indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }
        return res;
    }
}
