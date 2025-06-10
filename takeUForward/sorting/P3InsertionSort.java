package takeUForward.sorting;

public class P3InsertionSort {
    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        for ( int i=0; i<n; i++){
            int j=i;
            while ( j > 0 && nums[j-1] > nums[j] ){
                swap(nums, j, j-1);
                j--;
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
