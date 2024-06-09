package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P974SubarraySumsDivisibleByK {
    public int subarraysDivByKBruteForce(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            for ( int j=i; j<nums.length; j++){
                sum += nums[j];
                if (sum % k == 0){
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }

    public int subarraysDivByKOptimized(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for ( int i=0; i<nums.length; i++){
            sum = (sum+ nums[i])%k;
            if ( sum < 0 ) sum+= k;
            count += map.getOrDefault(sum,0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
