package takeUForward.dynamicProgramming.revision;

public class P14BestTimeToBuyAndSellStock {
    public int stockBuySell(int[] arr, int n) {
        // Think of it like time travel — if we're selling on day i,
        // to get the max profit, we should've bought at the lowest price from day 0 to (i - 1)
        int minPrice = arr[0];
        int maxProfit = 0;
        for ( int i=1; i<n; i++){
            maxProfit = Math.max(maxProfit, arr[i]-minPrice);
            minPrice = Math.min(minPrice, arr[i]);
        }
        return maxProfit;
    }
}
