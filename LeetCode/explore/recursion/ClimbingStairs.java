package leetcode.explore.recursion;

import java.util.HashMap;

public class ClimbingStairs {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> cache = new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,2);
        return helper(cache, n);
    }

    private int helper(HashMap<Integer, Integer> cache, int n) {
        if ( n < 0){
            return 0;
        }
        if ( cache.containsKey(n)){
            return cache.get(n);
        }
        int ans = helper(cache, n-1) + helper(cache, n-2);
        cache.put(n, ans);
        return ans;
    }
}