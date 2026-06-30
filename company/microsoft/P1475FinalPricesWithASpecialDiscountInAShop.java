package company.microsoft;

import takeUForward.trees.Inorder;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1475FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPricesBruteforce(int[] prices) {
        int [] res = prices.clone();
        int n = prices.length;
        for (int i=0; i<n; i++){
            for ( int j=i+1; j<n; j++){
                if ( prices[j] <= prices[i]) {
                    res[i] = res[i] - prices[j];
                    break;
                }
            }
        }
        return res;
    }

    public int[] finalPrices(int[] prices) {
        Deque<Integer> dq = new ArrayDeque<>();
        int [] res = prices.clone();
        for ( int i=0; i<prices.length; i++){
            while ( !dq.isEmpty() && prices[dq.peekLast()] >= prices[i]){
                res[dq.peekLast()] = res[dq.peekLast()] - prices[i];
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return res;
    }
}
