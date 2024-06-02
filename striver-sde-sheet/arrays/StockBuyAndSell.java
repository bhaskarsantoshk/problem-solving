class StockBuyAndSell {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for ( int i=0; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }
}
