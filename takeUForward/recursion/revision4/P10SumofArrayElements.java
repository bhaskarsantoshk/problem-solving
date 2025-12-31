package takeUForward.recursion.revision4;

public class P10SumofArrayElements {
    public int arraySum(int[] nums) {
        return arraySum(nums, 0, 0);
    }

    private int arraySum(int[] nums, int i, int sum) {
        if ( i == nums.length) return sum;
        return arraySum(nums, i+1, sum+nums[i]);
    }

    public int arraySum2(int[] nums) {
        return arraySum2(nums, 0);
    }

    private int arraySum2(int[] nums, int i) {
        if ( i == nums.length) return 0;
        return nums[i]+ arraySum2(nums, i+1);
    }

}
