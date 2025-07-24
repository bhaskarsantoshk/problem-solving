package takeUForward.dynamicProgramming.revision3;

import java.util.Arrays;

public class P3FrogJumpWithKDistances {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        return frogJump(heights, k, n-1);
    }

    private int frogJump(int[] heights, int k, int index) {
        if ( index <= 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        for ( int i=1; i<=k; i++){
           if ( index-i >=0 ) minEnergy = Math.min(minEnergy, frogJump(heights, k, index-i)+ Math.abs(heights[index]-heights[index-i]));
        }
        return minEnergy;
    }

    public int frogJumpMemo(int[] heights, int k) {
        int n = heights.length;
        int [] memo = new int[n];
        Arrays.fill(memo, -1);
        return frogJump(heights, k, n-1, memo);
    }

    private int frogJump(int[] heights, int k, int index, int [] memo) {
        if ( index <= 0) return 0;
        if ( memo[index] != -1) return memo[index];
        int minEnergy = Integer.MAX_VALUE;
        for ( int i=1; i<=k; i++){
            if ( index-i >=0 ) minEnergy = Math.min(minEnergy, frogJump(heights, k, index-i, memo)+ Math.abs(heights[index]-heights[index-i]));
        }
        return memo[index]= minEnergy;
    }
}
