package takeUForward.dynamicProgramming.revision;

public class P31RodCuttingProblem {
    public int RodCutting(int price[], int n) {
        return f(0, n, price);
    }

    private int f(int index, int n, int[] price) {
        if ( index == price.length){
            if ( n == 0) return 0;
            else return (int)-1e9;
        }
        int notTake = f(index+1, n, price);
        int take = Integer.MIN_VALUE;
        int rodLength = index+1;
        if ( rodLength <= n){
            take = f(index+1, n-rodLength, price) + price[index];
        }
        return Math.max(take, notTake);
    }

    public int RodCuttingMemoized(int price[], int n) {
        int [][] dp = new int[n][n+1];
        return f(0, n, price);
    }

    private int f(int index, int n, int[] price, int[][] dp) {
        if ( index == price.length){
            if ( n == 0) return 0;
            else return (int)-1e9;
        }
        if ( dp[index][n] != -1) return dp[index][n];
        int notTake = f(index+1, n, price, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = index+1;
        if ( rodLength <= n){
            take = f(index+1, n-rodLength, price, dp) + price[index];
        }
        return dp[index][n] = Math.max(take, notTake);
    }

    public int RodCuttingTabular(int price[], int n) {
        int [][] dp = new int[n+1][n+1];
        for (int len = 0; len <= n; len++) {
            dp[n][len] = (len == 0) ? 0 : (int) -1e9; // beyond last index, invalid
        }

        for ( int index=n-1; index>=0; index--){
            int rodLength = index+1;
            for ( int len=0; len<=n; len++){
                int notTake = dp[index+1][len];
                int take = Integer.MIN_VALUE;
                if ( rodLength <= len){
                    take = dp[index][len-rodLength] + price[index];
                }
                dp[index][n] = Math.max(take, notTake);
            }
        }
        return dp[0][n];
    }
}
