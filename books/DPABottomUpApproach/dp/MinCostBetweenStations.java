package books.DPABottomUpApproach.dp;

public class MinCostBetweenStations {

    public int minCost(int [][]cost){
        int n = cost.length;
        int minCost[] = new int[n]; //minCost[i] is minimum  cost to reach station i from 0.
        minCost[0] = 0;
        minCost[1] = cost[0][1];

        for ( int i=2; i<n; i++){
            minCost[i] = cost[0][i];
            for (int j=1; j<i; j++){
                minCost[i] = Math.min (minCost[i], minCost[j] + cost[i][j]);
            }
        }
        return minCost[n-1];
    }
}
