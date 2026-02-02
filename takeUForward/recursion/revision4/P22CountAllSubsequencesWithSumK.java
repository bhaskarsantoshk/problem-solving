package takeUForward.recursion.revision4;

public class P22CountAllSubsequencesWithSumK {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return countSubsequenceWithTargetSum(nums, k, 0);
    }

    private int countSubsequenceWithTargetSum(int[] nums, int k, int index) {
        if ( k == 0) return 1;
        if ( k < 0 || index == nums.length) return 0;
        return countSubsequenceWithTargetSum(nums, k-nums[index], index+1) + countSubsequenceWithTargetSum(nums, k, index+1);
    }
}
