package takeUForward.recursion.revision2;

public class P7ReverseAnArray {
    public int[] reverseArray(int[] nums) {
        reverse(nums, 0, nums.length-1);
        return nums;
    }

    private void reverse(int[] nums, int left, int right) {
        if ( left >= right) return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        reverse(nums, left+1, right-1);
    }
}
