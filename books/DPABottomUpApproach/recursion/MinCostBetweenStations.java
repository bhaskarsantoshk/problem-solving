package books.DPABottomUpApproach.recursion;

public class MinCostBetweenStations {

    int[][] cost;

    int calculateMinCost( int s, int d){
        if ( s == d || s == d-1) return cost[s][d];
        int minCost = Integer.MAX_VALUE;
        for ( int i=s+1; i<d; i++){
          int temp = calculateMinCost(s,i)+ calculateMinCost(i+1, d);
          minCost = Math.min(minCost, temp);
        }
        
        return minCost;
    }


}
