package company.apple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1TwoSum {
    public int[] twoSumBruteForce(int[] nums, int target) {
       // brute force

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int n = nums.length;

        for ( int i=0; i<n; i++){
            for ( int j=i+1; j<n; j++){
                if ( nums[i]+ nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return res;
    }


    public int[] twoSum(int[] nums, int target) {
        // brute force

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        for ( int i=0; i<n; i++){
            if ( map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
