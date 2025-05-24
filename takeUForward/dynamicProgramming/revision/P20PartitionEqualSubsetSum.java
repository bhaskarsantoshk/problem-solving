package takeUForward.dynamicProgramming.revision;

public class P20PartitionEqualSubsetSum {
    public boolean equalPartition(int n, int[] arr) {
        int sum = 0;
        for ( int num: arr) sum+= num;
        if ( sum % 2 != 0) return false;
        return subsetSumEqualtoTarget(arr, sum/2);
    }

    public boolean subsetSumEqualtoTarget(int[] arr, int target) {
        // Refer P19 for intuitive solution
        int n = arr.length;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if ( arr[0] <= target) prev[arr[0]] = true;
        for ( int index=1; index<n; index++){
            boolean[] cur = new boolean[target+1];
            cur[0] = true;
            for ( int sum=1; sum<=target; sum++){
                boolean take = false;
                if(sum-arr[index] >=0) take = prev[sum-arr[index]];
                boolean notTake = prev[sum];
                cur[sum] = take || notTake;
            }
            prev = cur;
        }
        return prev[target];
    }
}
