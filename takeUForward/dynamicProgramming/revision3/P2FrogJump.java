package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P2FrogJump {
    public int frogJump(int[] heights) {
        int n = heights.length;
        return frogJump(heights, n-1);
    }

    private int frogJump(int[] heights, int index) {
        if ( index <= 0) return 0;
        int take = frogJump(heights, index-1)+ Math.abs(heights[index]-heights[index-1]);
        int notTake = Integer.MAX_VALUE;
        if ( index >= 2) {
            notTake = frogJump(heights, index - 2) + Math.abs(heights[index]-heights[index-2]);
        }
        return Math.min(take, notTake);
    }

    public int frogJumpMemo(int[] heights) {
        int n = heights.length;
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return frogJump(heights, n-1, memo);
    }

    private int frogJump(int[] heights, int index, int[] memo) {
        if ( index <= 0) return 0;
        if( memo[index] != -1) return memo[index];
        int take = frogJump(heights, index-1, memo)+ Math.abs(heights[index]-heights[index-1]);
        int notTake = Integer.MAX_VALUE;
        if ( index >= 2) {
            notTake = frogJump(heights, index - 2, memo) + Math.abs(heights[index]-heights[index-2]);
        }
        return memo[index] = Math.min(take, notTake);
    }

    public int frogJumpDP(int[] heights) {
        int n = heights.length;
        int [] dp = new int[n];
        for ( int i=1; i<n; i++){
            int take = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int notTake = Integer.MAX_VALUE;
            if ( i>=2){
                notTake = dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dp[i]= Math.min(take, notTake);
        }
        return dp[n-1];
    }
}
