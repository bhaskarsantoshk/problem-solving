package striver_sde_sheet.arrays;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    public int[] twoSumBruteForce(int[] nums, int target) {
        int [] res = {-1,-1};
        if ( nums == null || nums.length < 2) return res;
        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                if ( nums[i] + nums[j] == target ) return new int[]{i,j};
            }
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int [] res = {-1,-1};
        if ( nums == null || nums.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i=0; i<nums.length; i++){
            if ( map.containsKey(target-nums[i])) return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        return res;
    }
}
