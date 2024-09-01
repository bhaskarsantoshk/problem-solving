package company.google.trees_and_graphs;

public class P1514PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){
        //  Bellman Ford Algorithm
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;
        boolean hasUpdate = false;

        for ( int i=0; i<n-1; i++){
            for ( int j=0; j<edges.length; j++){
                double pathProb = succProb[j];
                int u = edges[j][0];
                int v = edges[j][1];

                if ( maxProb[u] * pathProb > maxProb[v]){
                    maxProb[v] = maxProb[u] * pathProb;
                    hasUpdate = true;
                }

                if ( maxProb[v] * pathProb > maxProb[u]){
                    maxProb[u] = maxProb[v] * pathProb;
                    hasUpdate = true;
                }
            }
            if ( !hasUpdate) break;
        }
        return maxProb[end];
    }
}
