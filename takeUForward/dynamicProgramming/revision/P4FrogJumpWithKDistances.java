package takeUForward.dynamicProgramming.revision;

import java.util.Arrays;

public class P4FrogJumpWithKDistances {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        return frogJump(heights, k, n-1);
    }

    private int frogJump(int[] heights, int k, int index) {
        if ( index == 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        for ( int i=1; i<=k; i++){
            if (index - i >= 0)  minEnergy = Math.min( minEnergy, frogJump(heights, k, index-i)+ Math.abs(heights[index]-heights[index-i]));
        }
        return minEnergy;
    }

    public int frogJumpMemoIzation(int[] heights, int k) {
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return frogJump(heights, k, n-1, dp);
    }

    private int frogJump(int[] heights, int k, int index, int[] dp) {
        if ( index == 0) return 0;
        if ( dp[index] != -1) return dp[index];
        int minEnergy = Integer.MAX_VALUE;
        for ( int i=1; i<=k; i++){
            if (index - i >= 0)  minEnergy = Math.min( minEnergy, frogJump(heights, k, index-i, dp)+ Math.abs(heights[index]-heights[index-i]));
        }
        return dp[index] = minEnergy;
    }

    private int frogJumpTabulation(int[] heights, int k) {
        int n = heights.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for ( int i=1; i<n; i++){
            int minEnergy = Integer.MAX_VALUE;
            for ( int jump=1; jump<=k; jump++){
                if ( i-jump >= 0) minEnergy = Math.min( dp[i-jump]+Math.abs(heights[i]-heights[i-jump]), minEnergy);
            }
            dp[i] = minEnergy;
        }
        return dp[n-1];
    }
}
