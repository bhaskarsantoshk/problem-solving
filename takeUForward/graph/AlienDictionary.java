package takeUForward.graph;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] dict, int n, int k) {
        Set<Integer>[] G = new HashSet[k];
        for ( int i=0; i<k; i++) G[i] = new HashSet<>();
        int indegree[] = new int[k];
        for ( int i=0; i<n-1; i++){
            char[] a = dict[i].toCharArray();
            char[] b = dict[i+1].toCharArray();
            int aIndex = 0, bIndex = 0;
            while ( aIndex < a.length && bIndex < b.length){
                if ( a[aIndex] == b[bIndex]) {
                    aIndex++;
                    bIndex++;
                } else {
                    G[a[aIndex]-'a'].add(b[bIndex]-'a');
                    break;
                }
            }
        }
        for ( int i=0; i<k; i++){
            for ( int adjNode: G[i]) indegree[adjNode]++;
        }
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for ( int i=0; i<k;i++){
            if ( indegree[i] == 0) {
                q.offer(i);
            }
        }
        while ( !q.isEmpty()){
            int node = q.poll();
            char c = (char) ('a'+node);
            sb.append(c);
            for ( int adjNode: G[node]){
                if ( --indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        return sb.length() == k ? sb.toString() : "";
    }
}
