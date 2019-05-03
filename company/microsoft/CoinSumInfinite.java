package company.microsoft;

import java.util.ArrayList;

public class CoinSumInfinite {
    public int coinchange2(ArrayList<Integer> A, int B) {
        int dp[] = new int[B+1];
        dp[0] = 1;
        for(int coin : A){
            for(int i= coin; i<=B; i++){
                dp[i]+=dp[i-coin];
                dp[i]%=1000007;
            }
        }
        return dp[B];
    }
}
