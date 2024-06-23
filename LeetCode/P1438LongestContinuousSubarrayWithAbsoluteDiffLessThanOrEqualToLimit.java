package LeetCode;

import java.util.TreeMap;

public class P1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int i=0, j;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for ( j=0; j<nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if ( map.lastEntry().getKey() - map.firstEntry().getKey() > limit){
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if ( map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return j-i;
    }
}
