package company.apple;

import java.util.HashMap;
import java.util.Map;

public class P17SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {

        // stores: prefixSum -> number of times it occurred
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;

        // base case: prefix sum 0 seen once
        // allows subarrays starting from index 0
        map.put(prefixSum, 1);

        int count = 0;

        for (int num : nums) {

            // running sum from start to current index
            prefixSum += num;

            // if previous prefixSum = (currentPrefix - k)
            // then subarray between them has sum k
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // record current prefixSum occurrence
            // needed for future subarrays
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}