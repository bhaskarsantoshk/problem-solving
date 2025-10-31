package takeUForward.QR;

public class P2SortAnArrayOf0S1SAnd2S {
    public void sortZeroOneTwo(int[] nums) {
         int low = 0, mid = 0, high = nums.length-1;
         while ( mid <= high){
             if ( nums[mid] == 0){
                 swap(nums, low, mid);
                 low++;
                 mid++;
             } else if ( nums[mid] == 1){
                mid++;
             } else {
                 swap(nums, mid, high);
                 high--;
             }
         }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
