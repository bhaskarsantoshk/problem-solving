package company.microsoft;

import java.util.Arrays;

public class FrogJump {
    public static int frogJumpMemoized(int n, int heights[]) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return frogJumpRec(n-1, heights, memo);
    }

    private static int frogJumpRec(int index, int[] heights, int[] memo) {
        if ( index <= 0) return 0;
        if ( memo[index] != -1) return memo[index];
        int left = frogJumpRec(index-1, heights, memo)+ Math.abs(heights[index]-heights[index-1]);
        int right = Integer.MAX_VALUE;
        if ( index > 1){
            right = frogJumpRec(index-2, heights, memo) + Math.abs( heights[index]-heights[index-2]);
        }
        return memo[index]= Math.min(left, right);
    }


    public static int frogJumpTabular(int n, int heights[]) {
        int [] dp = new int[n];
        dp[0] = 0;
        for ( int i=1; i<n; i++){
            int firstStep = dp[i-1]+Math.abs(heights[i]-heights[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if ( i> 1){
                secondStep = dp[i-2]+Math.abs(heights[i]-heights[i-2]);
            }
            dp[i] = Math.min(firstStep, secondStep);
        }
        return dp[n-1];
    }


}
