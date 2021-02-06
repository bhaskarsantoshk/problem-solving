package bytebybyte;
import java.util.Arrays;

public class MakingChange {

    public int changeRec( int sum, int[] coins){
        if ( sum == 0) return 0;
        int minimum = sum; // there can't be more coins than all 1s as coins
        for ( int coin: coins){
            if ( sum - coin >= 0) {
                int c = changeRec(sum - coin, coins);
                minimum = Math.min(c+1, minimum);
            }
        }
        return  minimum;
    }


    public int change( int sum, int[] coins){
        int[] cache = new int[sum];
        for ( int i=1; i<sum; i++){
            cache[i] = -1;
        }
        return change(sum, coins, cache);
    }

    public int change( int sum, int[] coins, int cache[]){
        if ( sum == 0) return 0;
        int minimum = sum; // there can't be more coins than all 1s as coins
        for ( int coin: coins){
            if ( sum - coin >= 0) {
                int c;
                if (cache[sum-coin] >= 0){
                    c = cache[sum-coin];
                }
                else{
                    c = change(sum - coin, coins, cache);
                    cache[sum-coin] = c;
                }
                minimum = Math.min(c+1, minimum);
            }
        }
        return  minimum;
    }

}

// 1 5 10 20 25
// 1 3 4
/*
 Coin system could be anything
 Determine minimum number of coins to make sum
 Greedy approach: Take largest coin and reduce as much as possible - won't work always

 x = 6, coins = [1,3,4] ; if we take coin 4, it will be wrong - so, greedy approach is not the solution
 Greedy works with american coin system with 1 5 10 20 25

 1 5 10 20 25
 x = 1 op : 1
 x = 2 op : 2
 x = 11 op : 2
 x = 5 op: 1

 x = 32

 minimum (
 change (32 - 25)
 change (32 - 10)
 change ( 32 - 5)
 change ( 32 -1 )
 }


 */

