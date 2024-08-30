package takeUForward.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountWaysTargetSumPlusMinus {
    public static int targetSum(int n, int target, int[] arr) {
        int diff = target;
        // sum1+sum2 = total
        // sum1-sum2 = diff
        // sum1 = (total-diff)/2
        // total-diff always has to be an even number, else it's not possible to come up with a fraction sum with int

        int total =0;
        for ( int num: arr) total+= num;
        int sum = (total-target)/2;
        if ( (total - target)%2 != 0) return 0;
        return countSubSetsWithGivenSum(arr, sum);
    }

    private static int countSubSetsWithGivenSum(int[] arr, int sum) {
        return countSubSetsWithGivenSum(arr, arr.length-1, sum);
    }

    private static int countSubSetsWithGivenSum(int[] arr, int index, int target) {
        if ( index == 0){
            if ( arr[index] == 0 &&  target == 0 ) return 2;
            else if ( target == 0 || arr[index] == target) return 1;
        }
        int notTake = countSubSetsWithGivenSum(arr, index-1, target);
        int take = 0;
        if ( arr[index] <= target){
            take = countSubSetsWithGivenSum(arr, index-1, target-arr[index]);
        }
        return take+notTake;
    }

    private static int countSubSetsWithGivenSumMemoized(int[] arr, int sum) {
        Map<String, Integer> memo = new HashMap<>();
        return countSubSetsWithGivenSumMemoized(arr, arr.length-1, sum, memo);
    }

    private static final int MOD = 1000000007;

    private static int countSubSetsWithGivenSumMemoized(int[] arr, int index, int target, Map<String, Integer> memo) {
        if ( index == 0){
            if ( arr[index] == 0 &&  target == 0 ) {
                memo.put(index+","+target, 2);
                return 2;
            }
            else if ( target == 0 || arr[index] == target) {
                memo.put(index+","+target, 1);
                return 1;
            } else{
                return 0;
            }
        }
        if ( index < 0) return 0;
        if ( memo.containsKey(index+","+target)) return memo.get(index+","+ target);
        int notTake = countSubSetsWithGivenSumMemoized(arr, index-1, target, memo);
        int take = 0;
        if ( arr[index] <= target){
            take = countSubSetsWithGivenSumMemoized(arr, index-1, target-arr[index], memo);
        }
        int ans = ((take)%MOD + (notTake)%MOD)%MOD;
        memo.put(index+","+target, ans);
        return ans;
    }
}
