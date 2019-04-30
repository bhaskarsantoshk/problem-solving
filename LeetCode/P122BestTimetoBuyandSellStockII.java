package LeetCode;

public class P122BestTimetoBuyandSellStockII {
    //Logically Correct
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i+1] > prices[i]){
                maxProfit += (prices[i+1]- prices[i]);
            }
        }
        return maxProfit;
    }

    //Conceptually and logically correct
    public int maxProfit(int[] prices) {
        int buy=0;
        int sell=0;
        int index =0;
        int n = prices.length-1;
        int profit = 0;
        while( index < n){
            while(index < n && prices[index+1] <= prices[index]) index++;
            buy = prices[index];
            while (index<n && prices[index+1] > prices[index]) index++;
            sell = prices[index];
            profit += sell - buy;
        }
        return profit;
    }
}
