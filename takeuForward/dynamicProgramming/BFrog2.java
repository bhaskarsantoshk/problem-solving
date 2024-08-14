package takeuForward.dynamicProgramming;

import java.util.Arrays;

public class BFrog2 {

    public static int frogJump(int n, int heights[], int k) {
        return frogJump(heights, n-1, k);
    }

    private static int frogJump(int[] heights, int index, int k) {
        if ( index == 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        for ( int j=1; j<=k; j++){
            if ( index-j >=0 ) {
                int jump = frogJump(heights, index - j, k) + Math.abs(heights[index] - heights[index - j]);
                minEnergy = Math.min(jump, minEnergy);
            }
        }
        return minEnergy;
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(frogJump(n, height, k)); // Print the result of the solve function , ans = 40
        System.out.println(frogJumpMemoized(n, height, k)); // Print the result of the solve function , ans = 40
        System.out.println(frogJumpTabular(n, height, k)); // Print the result of the solve function , ans = 40
    }

    public static int frogJumpMemoized(int n, int heights[], int k) {
        int memo[] = new int [n];
        Arrays.fill(memo, -1);
        return frogJumpMemoized(heights, n-1, k, memo);
    }

    private static int frogJumpMemoized(int[] heights, int index, int k, int [] memo) {
        if ( index == 0) return 0;
        if ( memo[index] != -1 ) return memo[index];
        int minEnergy = Integer.MAX_VALUE;
        for ( int j=1; j<=k; j++){
            if ( index-j >=0 ) {
                int jump = frogJumpMemoized(heights, index - j, k, memo) + Math.abs(heights[index] - heights[index - j]);
                minEnergy = Math.min(jump, minEnergy);
            }
        }
        return memo[index] = minEnergy;
    }

    public static int frogJumpTabular(int n, int heights[], int k) {
        int[] dp = new int[n];
        dp[0] = 0;
        for ( int i=1; i<n ; i++) {
            int minEnergy = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i-j] + Math.abs(heights[i] - heights[i - j]);
                    minEnergy = Math.min(jump, minEnergy);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[n-1];
    }
}
