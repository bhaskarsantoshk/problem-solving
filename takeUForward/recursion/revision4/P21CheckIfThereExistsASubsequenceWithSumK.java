package takeUForward.recursion.revision4;

public class P21CheckIfThereExistsASubsequenceWithSumK {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return checkSubsequenceSum(nums, k, 0);
    }

    private boolean checkSubsequenceSum(int[] nums, int k, int index) {
        if ( k == 0) return true;
        if ( index == nums.length || k < 0) return false;
        boolean take = checkSubsequenceSum(nums, k-nums[index], index+1);
        if ( take) return true;
        return checkSubsequenceSum(nums, k, index+1);
    }
}
