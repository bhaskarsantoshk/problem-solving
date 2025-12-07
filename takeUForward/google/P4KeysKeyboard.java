package takeUForward.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P4KeysKeyboard {
    public int maxA(int n) {
        if ( n <=0 ) return 0;
        if ( n <=5 ) return n;
        int best = maxA(n-1)+1;
        for ( int i=1; i<=n-3; i++){
            best = Math.max(best, (i+1)*maxA(n-i-2));
        }
        return best;
    }

    public int maxAMemoized(int n) {
       int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
       return maxAMemoized(n, dp);
    }

    private int maxAMemoized(int n, int[] dp) {
        if ( n <=0 ) return 0;
        if ( n <=5 ) return n;
        if ( dp[n] != -1) return dp[n];
        int best = maxAMemoized(n-1, dp)+1;
        for ( int i=1; i<=n-3; i++){
            best = Math.max(best, (i+1)*maxAMemoized(n-i-2, dp));
        }
        return dp[n]= best;
    }

    public int maxADP(int n) {
        if ( n <= 5) return n;
        int[] dp = new int[n+1];
        for ( int i=1; i<=5; i++) dp[i] = i;
        for ( int key=6; key<=n; key++){
            int best = dp[key-1]+1;
            for ( int i=1; i<=key-3; i++){
                best = Math.max(best, (i+1)*dp[key-i-2]);
                dp[key] = best;
            }
        }
        return dp[n];
    }
}
