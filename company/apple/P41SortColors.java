package company.apple;

public class P41SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;

        // 0 - low-1 : 0
        // low - mid-1: 1
        // mid - high : unsorted
        // high+1 - n-1: 2

        // 0000000 111111 01020 22222

        while ( mid <= high){
            if ( nums[mid] == 0 ){
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

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
