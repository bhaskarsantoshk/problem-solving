package takeUForward.dynamicProgramming.revision3;

public class P15BestTimeToBuyAndSellStockIV {
    public int stockBuySell(int[] arr, int n, int k) {
        int[][][] dp = new int[n + 1][2][k+1];

        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= k; cap++) {
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-arr[day] + dp[day + 1][0][cap], dp[day + 1][1][cap]);
                    } else {
                        profit = dp[day + 1][0][cap];
                        if (cap >= 1) profit = Math.max(arr[day] + dp[day + 1][1][cap - 1], profit);
                    }
                    dp[day][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][k];
    }
}
