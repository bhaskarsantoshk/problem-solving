package company.microsoft;

import javax.swing.*;
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

    public static int frogJumpConstantSpace(int n, int heights[]) {
        if ( n <= 0) return 0;
        int ans , prev, prev2;
        ans = 0;
        prev = 0;
        prev2 = 0;
        for ( int i=1; i<n; i++){
            int firstStep = prev+Math.abs(heights[i]-heights[i-1]);
            int secondStep = Integer.MAX_VALUE;
            if ( i> 1){
                secondStep = prev2+Math.abs(heights[i]-heights[i-2]);
            }
            ans = Math.min(firstStep, secondStep);
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }

    // Follow up K jumps
    // Leetcode 403
    public static int frogJumpTabularKSteps(int n, int heights[], int k) {
        int [] dp = new int[n];
        dp[0] = 0;
        for ( int i=1; i<n; i++){
            int min = Integer.MAX_VALUE;
            for ( int step=1; step<=k && i>=k; step++){
                min = Math.min(min, dp[i-step]+ Math.abs(heights[i]-heights[i-k]));
            }
            dp[i] = min;
        }
        return dp[n-1];
    }

    // reduce further to k space

}
