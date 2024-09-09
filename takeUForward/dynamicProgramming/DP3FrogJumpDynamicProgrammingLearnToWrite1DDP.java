package takeUForward.dynamicProgramming;

import java.util.Arrays;

public class DP3FrogJumpDynamicProgrammingLearnToWrite1DDP {
    public static int frogJump(int n, int heights[]) {
        return minEnergy( n-1, heights);
    }

    private static int minEnergy(int index, int[] heights) {
        if ( index == 0) return 0;
        int firstStep = minEnergy(index-1, heights)+ Math.abs(heights[index]-heights[index-1]);
        int secondStep = Integer.MAX_VALUE;
        if ( index > 1){
            secondStep = minEnergy(index-2, heights)+ Math.abs(heights[index]-heights[index-2]);
        }
        return Math.min(firstStep, secondStep);
    }

    public static int frogJumpMemo(int n, int heights[]) {
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return minEnergyMemo( n-1, heights, memo);
    }

    private static int minEnergyMemo(int index, int[] heights, int [] memo) {
        if ( index == 0) return memo[index]= 0;
        if ( memo[index] != -1) return memo[index];
        int firstStep = minEnergyMemo(index-1, heights, memo)+ Math.abs(heights[index]-heights[index-1]);
        int secondStep = Integer.MAX_VALUE;
        if ( index > 1){
            secondStep = minEnergyMemo(index-2, heights, memo)+ Math.abs(heights[index]-heights[index-2]);
        }
        return memo[index] = Math.min(firstStep, secondStep);
    }

    public static int frogJumpTabular(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        for ( int index=1; index<n; index++){
            int firstStep = dp[index-1] + Math.abs(heights[index]-heights[index-1]);
            int secondStep = Integer.MAX_VALUE;
            if ( index > 1){
                secondStep = dp[index-2]+ Math.abs(heights[index]-heights[index-2]);
            }
            dp[index] = Math.min(firstStep, secondStep);
        }
        return dp[n-1];
    }

    public static int frogJumpTabularSpaceOptimized(int n, int heights[]) {
        int cur= 0, prev = 0, prev2=0;
        for ( int index=1; index<n; index++){
            int firstStep = prev + Math.abs(heights[index]-heights[index-1]);
            int secondStep = Integer.MAX_VALUE;
            if ( index > 1){
                secondStep = prev2+ Math.abs(heights[index]-heights[index-2]);
            }
            cur = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
}
