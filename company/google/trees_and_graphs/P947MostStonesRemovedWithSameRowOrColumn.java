package company.google.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P947MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        List<Integer>[] adj = new ArrayList[stones.length];
        for ( int i=0; i<stones.length; i++) adj[i] = new ArrayList<>();

        for ( int i=0; i<stones.length; i++){
            for ( int j=i+1; j<stones.length; j++){
                if ( shareSameRowOrColumn(stones[i], stones[j])){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int[] visited = new int[stones.length];
        int componentCount = 0;
        for ( int i=0; i<stones.length; i++){
            if ( visited[i]== 0) {
                componentCount++;
                dfs(stones, adj, visited, i);
            }
        }
        return stones.length-componentCount;
    }

    private void dfs(int[][] stones, List<Integer>[] adj, int[] visited, int src) {
        visited[src] = 1;
        for ( int adjacent: adj[src]){
            if ( visited[adjacent] == 0){
                dfs(stones, adj, visited, adjacent);
            }
        }
    }

    private boolean shareSameRowOrColumn(int[] stone1, int[] stone2) {
        return stone1[0] == stone2[0] || stone1[1] == stone2[1];
    }

    public int removeStones2(int[][] stones) {
        if ( stones == null || stones.length == 0) return 0;
        Set<int[]> visited = new HashSet<>();
        int numIslands = 0;
        for ( int[] stone: stones){
            if ( !visited.contains(stone)){
                dfs2(stones, stone, visited);
                numIslands++;
            }
        }
        return stones.length-numIslands;
    }

    private void dfs2(int[][] stones, int[] stone1, Set<int[]> visited) {
        visited.add(stone1);
        for ( int[]stone2: stones){
            if ( !visited.contains(stone2) && (stone1[0] == stone2[0] || stone1[1] == stone2[1])) {
                dfs2(stones, stone2, visited);
            }
        }
    }
}
