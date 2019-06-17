package LeetCode;

import java.util.HashMap;

public class P560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if ( nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;
        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
            if (map.containsKey(sum-k)){
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
