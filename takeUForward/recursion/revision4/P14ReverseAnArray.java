package takeUForward.recursion.revision4;

public class P14ReverseAnArray {
    public int[] reverseArray(int[] nums) {
        reverse(nums, 0, nums.length-1);
        return nums;
    }

    private void reverse(int[] nums, int start, int end) {
        if ( start >= end) return;
        swap(nums, start, end);
        reverse(nums , start+1, end-1);
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
