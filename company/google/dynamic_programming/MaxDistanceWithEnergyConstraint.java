package company.google.dynamic_programming;
/*
You are stuck on a boat in the middle of the ocean with an initial energy k (k < 1000).
You are given an array A of length n, where A[i] represents the wind speed on the i-th day.
For n consecutive days:
	•	Each day, you can either:
	•	Travel: Move forward A[i] units and lose 1 unit of energy.
	•	Rest: Stay in place and gain 1 unit of energy.
	•	Your energy must never go below 0 and never exceed the initial maximum k.
	•	You start on day 0 with energy k.

Goal: Determine the maximum total distance you can travel over n days without violating energy constraints.
 */

import java.util.Arrays;

public class MaxDistanceWithEnergyConstraint {
    public int maxDistance(int[] a, int k, int n){
        return dfs(a, k, 0, k);
    }

    private int dfs(int[] a, int k, int index, int energy) {
        if ( index == a.length) return 0;
        int rest = dfs(a, k, index+1, Math.min(k, energy+1));
        int travel = 0;
        if ( energy > 0) travel = a[index]+dfs(a, k, index+1, energy-1);
        return Math.max(rest, travel);
    }

    public int maxDistanceMemoized(int[] a, int k, int n){
        int [][] dp = new int[n][k+1];
        for ( int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return dfs(a, k, 0, k, dp);
    }

    private int dfs(int[] a, int k, int index, int energy, int[][] dp) {
        if ( index == a.length) return 0;
        if ( dp[index][energy] != -1) return dp[index][energy];
        int rest = dfs(a, k, index+1, Math.min(k, energy+1), dp);
        int travel = 0;
        if ( energy > 0) travel = a[index]+dfs(a, k, index+1, energy-1, dp);
        return dp[index][energy] = Math.max(rest, travel);
    }

    public int maxDistanceTabular(int[] a, int k, int n){
        int [][] dp = new int[n+1][k+1];
        for ( int day=n-1; day>=0; day--){
            for ( int e=0; e<=k; e++){
                int rest = dp[day+1][Math.min(k, e+1)];
                int travel =0;
                if ( e > 0) travel = a[day]+ dp[day+1][e-1];
                dp[day][e] = Math.max(rest, travel);
            }
        }
        return dp[0][k];
    }

}
