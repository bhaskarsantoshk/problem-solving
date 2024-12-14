package LeetCode;

public class P2044CountNumberOfMaximumBitwiseORSubsets {
    int result = 0;
    public int countMaxOrSubsets(int[] nums) {
        countMaxOrSubsets(nums, nums.length-1, result);
        return result;
    }

    private int countMaxOrSubsets(int[] nums, int index, int result) {
        return 0;
    }
}
