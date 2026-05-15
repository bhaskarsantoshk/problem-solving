package company.google.version2;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i=0; i<nums.length-1; i++){
            for ( int j=i+1; j<nums.length; j++){
                if ( nums[i] + nums[j] == target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }


    public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if ( map.containsKey(target-nums[i])) return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
