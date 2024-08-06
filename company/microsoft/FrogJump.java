package company.microsoft;

import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int n, int heights[]) {
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
}
