package takeUForward.recursion.revision2;

public class P14CountAllSubsequencesWithSumK {
    int count = 0;
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        generate(nums, k, 0, 0);
        return count;
    }

    private void generate(int[] nums, int target, int index, int sum) {
        if ( index >= nums.length){
            if ( sum == target){
                count++;
            }
            return;
        }
        generate(nums, target, index+1, sum+ index);
        generate(nums, target, index+1, sum);
    }

    public int countSubsequenceWithTargetSum2(int[] nums, int k) {
        return countSubsequenceWithTargetSum(nums, k, 0, 0);
    }

    private int countSubsequenceWithTargetSum(int[] nums, int target, int index, int sum) {
        if ( index >= nums.length){
            if ( sum == target){
                return 1;
            }
            return 0;
        }
        int path1 = countSubsequenceWithTargetSum(nums, target, index, sum+nums[index]);
        int path2 = countSubsequenceWithTargetSum(nums, target, index, sum);
        return path1+path2;
    }
}
