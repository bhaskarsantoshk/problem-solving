package data_structures.arrays;

public class StocksMaxProfitWithSingleTRN {
    public static int maxProfit(int[] prices){
        if ( prices == null || prices.length == 0){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;

        for ( int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }

}
