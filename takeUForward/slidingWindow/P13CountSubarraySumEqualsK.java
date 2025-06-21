package takeUForward.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class P13CountSubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum =0;
        int count = 0;
        prefixSum.put(0, 1);
        for ( int i=0; i<nums.length; i++){
            sum+= nums[i];
            count += prefixSum.getOrDefault(sum-k, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
