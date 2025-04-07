package takeUForward.greedy.revision;

import java.util.Arrays;

public class P5JumpGame {
    public static int minJumpsRec(int []arr, int n) {
        if ( !canJump(arr, n)) return -1;
        return minJumpsRec(arr, n, 0, 0);
    }

    private static boolean canJump(int[] a, int n){
        int maxIndexWeCanGo = 0;
        for ( int i=0; i<n; i++){
            if ( i > maxIndexWeCanGo ) return false;
            maxIndexWeCanGo = Math.max( maxIndexWeCanGo, i+a[i]);
        }
        return true;
    }

    private static int minJumpsRec(int[] arr, int n, int index, int jumps) {
        if ( index >= n-1) return jumps;
        int min = Integer.MAX_VALUE;
        for ( int i=1; i<=arr[index]; i++){
            min = Math.min( min, minJumpsRec(arr, n, i+index, jumps+1));
        }
        return min;
    }

    public static int minJumpsMemoized(int []arr, int n) {
        if ( !canJump(arr, n)) return -1;
        int[][] memo = new int[n][n];
        for(int [] a: memo) Arrays.fill(a, -1);
        return minJumpsMemoized(arr, n, 0, 0, memo);
    }

    private static int minJumpsMemoized(int[] arr, int n, int index, int jumps, int[][] memo){
        if ( index >= n-1) return jumps;
        if ( memo[index][jumps] != -1) return memo[index][jumps];
        int min = Integer.MAX_VALUE;
        for ( int i=1; i<=arr[index]; i++){
            min = Math.min( min, minJumpsMemoized(arr, n, i+index, jumps+1, memo));
        }
        return memo[index][jumps] = min;
    }

    // Optimized - Greedy

    public static int minJumps(int []arr, int n) {
        if ( !canJump(arr, n)) return -1;
        int jumps =0, left=0, right = 0;
        while ( right < n-1){
            int fathest = 0;
            for ( int i=left; i<=right; i++){
                fathest = Math.max(i+arr[i], fathest);
            }
            left = right+1;
            right = fathest;
            jumps++;
        }
        return jumps;
    }

}
