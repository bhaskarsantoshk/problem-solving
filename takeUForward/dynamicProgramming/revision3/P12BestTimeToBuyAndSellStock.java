package takeUForward.dynamicProgramming.revision3;

public class P12BestTimeToBuyAndSellStock {
    public int stockBuySell(int[] arr, int n) {
        // Time travel - if we are selling on ith day,
        // to get max profit - we should have bought it when the min price is there among 0-(i-1)
        int minPrice = arr[0];
        int maxProfit = 0;
        for ( int i=1; i<arr.length; i++){
            maxProfit = Math.max(maxProfit, arr[i]-minPrice);
            minPrice = Math.min(minPrice, arr[i]);
        }
        return maxProfit;
    }
}
