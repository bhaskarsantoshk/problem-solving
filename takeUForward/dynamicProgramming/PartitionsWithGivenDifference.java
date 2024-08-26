package takeUForward.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class PartitionsWithGivenDifference {
    public static int countPartitions(int n, int d, int[] arr) {
        // sum1 - sum2 = d
        // total = sum1 + sum2
        // total = d + sum2 + sum2
        // sum2 = (total-d)/2
        int total = 0;
        for ( int num: arr) total += num;
        int target = (total-d)/2;
        return countSubSetsWithGivenSum(arr, target);
    }

    private static int countSubSetsWithGivenSum(int [] arr, int target){
        Map<String, Integer> memo = new HashMap<>();
        return countPartitions(arr, target, arr.length-1, memo);
    }
    private static int MOD = 1000000007;
    private static int countPartitions(int[] nums, int target, int index, Map<String, Integer> memo) {
        if ( index == 0){
            if ( target == 0 && nums[index] == 0) {
                memo.put(index+" "+target, 2);
                return 2;
            }
            if ( target == 0 || target == nums[0] ) {
                memo.put(index+" "+target, 1);
                return 1;
            }
            else return 0;
        }
        if ( index <0 ) return 0;
        if ( memo.containsKey(index+" "+target)) return memo.get(index+" "+target);
        int pick = 0;
        if ( nums[index] <= target) pick = countPartitions(nums, target-nums[index], index-1, memo);
        int nonPick = countPartitions(nums, target, index-1, memo);
        int ans =  (pick% MOD + nonPick%MOD) % MOD;
        memo.put(index+" "+target, ans);
        return ans;
    }
}
