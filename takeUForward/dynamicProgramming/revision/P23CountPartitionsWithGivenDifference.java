package takeUForward.dynamicProgramming.revision;

import java.util.HashMap;
import java.util.Map;

public class P23CountPartitionsWithGivenDifference {
    int mod = (int)1e9+7;
    public int countPartitions(int n, int diff, int[] arr) {
        // sum1 - sum2 = diff
        // total_sum = sum1 + sum2
        // total_sum = diff + 2 * sum2
        // sum2 = (total_sum -diff)/2
        int totalSum = 0;
        for ( int num: arr) totalSum+= num;
        if ( diff > totalSum) return 0;
        if ( (totalSum-diff) % 2 == 1) return 0;
        int target = (totalSum-diff) / 2;
        return countSubsetSumK(arr, n-1, target);
    }

    private int countSubsetSumK(int[] arr, int index, int target) {
        if ( index == 0){
            if ( target == 0 && arr[index]== 0) return 2;
            if ( target == 0 || arr[index] == target) return 1;
            return 0;
        }
        int notTake = countSubsetSumK(arr, index-1, target);
        int take = 0;
        if ( target-arr[index] >= 0) countSubsetSumK(arr, index-1, target-arr[index]);
        return (take+notTake)%mod;
    }

    public int countPartitionsMemoized(int n, int diff, int[] arr) {
        // sum1 - sum2 = diff
        // total_sum = sum1 + sum2
        // total_sum = diff + 2 * sum2
        // sum2 = (total_sum -diff)/2
        int totalSum = 0;
        for ( int num: arr) totalSum+= num;
        if ( diff > totalSum) return 0;
        if ( (totalSum-diff) % 2 == 1) return 0;
        int target = (totalSum-diff) / 2;
        Map<String, Integer> map = new HashMap<>();
        return countSubsetSumK(arr, n-1, target, map);
    }

    private int countSubsetSumK(int[] arr, int index, int target, Map<String, Integer> map) {
        if ( index == 0){
            if ( target == 0 && arr[index]== 0) return 2;
            if ( target == 0 || arr[index] == target) return 1;
            return 0;
        }
        String key = index+" "+target;
        if ( map.containsKey(key)) return map.get(key);
        int notTake = countSubsetSumK(arr, index-1, target);
        int take = 0;
        if ( target-arr[index] >= 0) take = countSubsetSumK(arr, index-1, target-arr[index]);
        int val =  (take+notTake)%mod;
        map.put(key, val);
        return val;
    }


}
