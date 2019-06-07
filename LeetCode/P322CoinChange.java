package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P322CoinChange {
    Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
    public int coinChange(int[] coins, int amount) {
       if ( amount == 0) return 0;
       if (amountDict.containsKey(amount)){
           return amountDict.get(amount);
       }
       int min = amount+1;
       for (int coin : coins ) {
           int current = 0;
           if (amount - coin >= 0) {
               int c = coinChange(coins, amount - coin);
               if (c >= 0) {
                   current = 1 + c;
               }
           }
           if (current > 0) {
               min = Math.min(current, min);
           }
       }
       int finalCount = (min == amount+1 ) ? -1 : min;
       amountDict.put(amount, finalCount);
       return finalCount;
    }
}
