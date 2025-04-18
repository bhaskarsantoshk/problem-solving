package takeUForward.arrays;

public class P9LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        if ( nums == null || nums.length == 0) return;
        int temp = nums[0];
        for ( int i=1; i<nums.length; i++ ){
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = temp;
    }
}
