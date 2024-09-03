package takeUForward.graph;
import java.util.ArrayList;
import java.util.List;

public class G55BridgesInGraphUsingTarjanSAlgorithmOfTimeInAndLowTime {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] G = new ArrayList[n];
        for ( int i=0; i<n; i++){
            G[i] = new ArrayList<>();
        }
        for ( List<Integer> conn: connections) {
            G[conn.get(0)].add(conn.get(1));
            G[conn.get(1)].add(conn.get(0));
        }
        int [] timeOfInsertion = new int[n];
        int [] low = new int[n]; // min of all adjacent time of insertion except parent
        boolean[] vis = new boolean[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs( 0, -1, bridges, G, vis, timeOfInsertion, low);
        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> bridges, List<Integer>[] g,
                     boolean[] vis, int[] timeOfInsertion, int[] low) {
        vis[node] = true;
        timeOfInsertion[node] = low[node] = timer;
        timer++;
        for (int adjNode : g[node]) {
            if (adjNode == parent) continue;
            if (!vis[adjNode]) {
                dfs(adjNode, node, bridges, g, vis, timeOfInsertion, low);
                low[node] = Math.min(low[node], low[adjNode]);
                if (low[adjNode] > timeOfInsertion[node]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(node);
                    edge.add(adjNode);
                    bridges.add(edge);
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }
}
