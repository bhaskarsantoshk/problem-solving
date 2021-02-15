package leetcode_problems;

import java.util.HashMap;
import java.util.Map;

public class Problem_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for ( int i= 0; i<nums.length; i++){
            if ( map.containsKey(target-nums[i]) ){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
