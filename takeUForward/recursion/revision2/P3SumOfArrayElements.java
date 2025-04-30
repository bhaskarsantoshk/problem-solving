package takeUForward.recursion.revision2;

public class P3SumOfArrayElements {
    public int arraySum(int[] nums) {
        return arraySum(nums, 0);
    }

    private int arraySum(int[] nums, int i){
        if ( i  >= nums.length) return 0;
        return nums[i] + arraySum(nums, i+1);
    }
}
