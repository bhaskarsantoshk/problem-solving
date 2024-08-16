package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        // Topdown - pass n-1 as first index
       return frogJump(heights, n-1); // f(index) is min energy required for frog to reach index from 0.
    }

    // f(index) -> energy required to reach index from 0
    private static int frogJump(int[] heights, int index) {
        if ( index == 0 ) return 0; // base condition f(0) - min energy to reach 0 from 0

        int firstStep = frogJump( heights, index-1) + Math.abs(heights[index]-heights[index-1]);
        int secondStep = Integer.MAX_VALUE;
        if ( index >= 2 ) secondStep = frogJump( heights, index-2) + Math.abs(heights[index]-heights[index-2]);
        return Math.min(firstStep, secondStep);
    }

    public static int frogJumpMemoized(int n, int heights[]) {
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return frogJumpMemoized(heights, n-1, memo);
    }

    // f(index) -> energy required to reach index from 0
    private static int frogJumpMemoized(int[] heights, int index, int[] memo) {
        if ( index == 0 ) return 0;
        if ( memo[index] != -1) return memo[index];
        int firstStep = frogJumpMemoized( heights,index-1, memo) + Math.abs(heights[index]-heights[index-1]);
        int secondStep = Integer.MAX_VALUE;
        if ( index >= 2 ) secondStep = frogJumpMemoized( heights, index-2, memo) + Math.abs(heights[index]-heights[index-2]);
        return memo[index] = Math.min(firstStep, secondStep);
    }

    public static int frogJumpTabular(int n, int heights[]) {
        int [] dp = new int[n];
        if ( n <= 0) return 0;
        dp[0] = 0;
        for ( int i=1; i<n; i++){
            int firstStep = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if ( i>=2) secondStep = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            dp[i] = Math.min(firstStep, secondStep);
        }
        return dp[n-1];
    }

    public static int frogJumpTabularSpaceOptimized(int n, int heights[]) {
        if ( n <= 0) return 0;
        int prev = 0;
        int prev2 = 0;
        int ans = Integer.MAX_VALUE;
        for ( int i=1; i<n; i++){
            int firstStep = prev + Math.abs(heights[i]-heights[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if ( i>=2) secondStep = prev2 + Math.abs(heights[i]-heights[i-2]);
            ans = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}
