package takeUForward.binaryTrees;

import java.util.Arrays;

public class P3FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        return frogJump(heights, n-1);
    }

    private int frogJump(int[] heights, int index) {
        if ( index == 0) return 0;
        int left = frogJump(heights, index-1) + Math.abs(heights[index]-heights[index-1]);
        int right = Integer.MAX_VALUE;
        if ( index > 1){
            right = frogJump(heights, index-2) + Math.abs(heights[index] - heights[index-2]);
        }
        return Math.min(left, right);
    }

    public int frogJumpMemoized(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJump(heights, n-1, dp);
    }

    private int frogJump(int[] heights, int index, int[] dp) {
        if ( index == 0) return 0;
        if ( dp[index] != -1) return dp[index];
        int left = frogJump(heights, index-1, dp) + Math.abs(heights[index]-heights[index-1]);
        int right = Integer.MAX_VALUE;
        if ( index > 1){
            right = frogJump(heights, index-2, dp) + Math.abs(heights[index] - heights[index-2]);
        }
        return dp[index]= Math.min(left, right);
    }

    public int frogJumpTabular(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for ( int i=1; i<n; i++){
            int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if ( i>1) right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    public int frogJumpSpaceOptimized(int[] heights) {
        int n = heights.length;
        int prev = 0;
        int prev2 = 0;
        for ( int i=1; i<n; i++){
            int left = prev + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if ( i>1) right = prev2 + Math.abs(heights[i] - heights[i-2]);
            int cur = Math.min(left, right);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
