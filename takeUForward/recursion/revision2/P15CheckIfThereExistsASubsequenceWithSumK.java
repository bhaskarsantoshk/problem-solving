package takeUForward.recursion.revision2;

public class P15CheckIfThereExistsASubsequenceWithSumK {
    public boolean checkSubsequenceSum(int[] nums, int k) {
       return checkSubsequenceSum(nums, k, 0, 0);
    }

    private boolean checkSubsequenceSum(int[] nums, int target, int index, int sum) {
        if ( index >= nums.length){
            if ( sum == target) return true;
            return false;
        }
        boolean take = checkSubsequenceSum(nums, target, index+1, sum+ nums[index]);
        boolean notTake = checkSubsequenceSum(nums, target, index+1, sum);
        return take || notTake;
    }
}
