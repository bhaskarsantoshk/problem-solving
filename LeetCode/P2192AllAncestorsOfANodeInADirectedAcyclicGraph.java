package LeetCode;

import java.util.*;

public class P2192AllAncestorsOfANodeInADirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for ( int[] edge : edges ) {
            int u = edge[0];
            int v = edge[1];
            inDegree[v]++;
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Set<Integer>> ancestorSet  = new ArrayList<>();
        for ( int node = 0; node<n; node++){
            ancestorSet.add(new TreeSet<>());
            if ( inDegree[node] == 0){
                queue.add(node);
            }
        }


        while (!queue.isEmpty()){
            int parent = queue.poll();
            for ( int child : graph.getOrDefault(parent, new ArrayList<>())){
                ancestorSet.get( child ).add(parent);
                ancestorSet.get(child).addAll(ancestorSet.get(parent));
                if ( --inDegree[child] == 0 ) queue.offer(child);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for ( Set<Integer> set : ancestorSet ){
            result.add(new ArrayList<>(set));
        }
        return result;
    }
}
