package company.amazon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1010PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        // if we do time[i]%=60 for time[] , we can reduce this sum to two sum problem
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int t: time){
            res += map.getOrDefault((60 - t%60)%60, 0);
            map.put(t%60, map.getOrDefault(t%60, 0)+1);
        }
        return res;
    }
}

/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/636651/Java-Simple-Solution-with-with-a-crystal-clear-explanation(biginners-mindset)-HashMap-in-O(n)
 */
