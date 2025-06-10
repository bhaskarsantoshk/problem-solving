package takeUForward.sorting;

public class P2BubbleSort {
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for ( int i=n-1; i>=0; i--){
            for ( int j=0; j<=i-1; j++){
                if ( nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
