package company.amazon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if ( nums == null || nums.length == 0) return null;
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i<nums.length; i++){
            if ( map.containsKey(target-nums[i])) {
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
