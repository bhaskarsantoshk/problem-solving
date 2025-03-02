package takeUForward.blind75.bitManipulation;

public class CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        int offset = 1;
        for ( int i=1; i<=num; i++){
            if ( offset * 2 == i) offset = i;
            dp[i] = dp[i-offset];
        }
        return dp;
    }

    // 0 -> 000
    // 1 -> 001
    // 2 -> 010 // after this 1 + 0/1( same as last 4 ) dp[i-2]
    // 3 -> 011
    // 4 -> 100 // after this 1 + 00/01/10/11 ( same as last 4 ) dp[i-4]
    // 5 -> 101
    // 6 -> 110
    // 7 -> 111
    // 8 -> 1000

}
