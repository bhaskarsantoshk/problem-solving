package books.DPABottomUpApproach.memoization;

public class MinCostBetweenStations {

    int [][] cost;

    public int minCost(int s, int d){
        int [][] memo= new int[s+1][d+1];
        return minCost(s, d, memo);
    }

    private int minCost(int s, int d, int[][] memo) {
        if ( s == d || s== d-1){
            return cost[s][d];
        }
        if (memo[s][d] == 0){
            int minCost = Integer.MAX_VALUE;
            for ( int i=s+1; i<d; i++){
                int temp = minCost(s,i, memo) + minCost(i, d, memo);
                minCost = Math.min(minCost, temp);
            }
            memo[s][d] = minCost;
        }
        return memo[s][d];
    }
}
