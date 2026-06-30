package company.microsoft;

import java.util.Arrays;

public class P1029TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b)-> ((a[1]-a[0])-(b[1]-b[0])));
        int n = costs.length/2;
        int totalCost = 0;
        for ( int i=0; i<n; i++) totalCost += costs[i][1];
        for ( int i=n; i<2*n; i++) totalCost += costs[i][0];

        return totalCost;
    }
}
