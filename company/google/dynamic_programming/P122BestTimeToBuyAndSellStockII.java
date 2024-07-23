package company.google.dynamic_programming;

public class P122BestTimeToBuyAndSellStockII {
    // we can buy and sell as many times as we want
    // Try all ways and come up with the best possible outcome
    // Recursion
    // Express everything in terms of index , buy or not
    // explore possibilities that day
    // take the max of all profits made
    // base case

    // f(index, buy )
    // f(0,1 ) -> start with buy on 0th day -> what is the max profit
    // if ( buy ) max (
    // profit = -prices[i] , f(ind +1, 0)
    // profit , f( ind + 1 , 1)
    // )
    // else ->    max (
    // prices[ind] + f(ind+1, 1)
    // 0 + f(ind+1, 0)
    // )
    // return profit
    // base case -> if ( ind == n) return 0
    // T - O(2^N), S - O(N)
    public int maxProfit(int[] prices) {
        // TODO
        return 0;
    }
}
