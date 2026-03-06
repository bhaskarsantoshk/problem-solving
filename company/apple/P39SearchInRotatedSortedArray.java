package company.apple;

public class P39SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while ( low <= high){
            int mid = low + (high-low)/2;
            if ( nums[mid] == target) return mid;

            // check if left sorted
            if ( nums[low] <= nums[mid]){

                // check if target comes between low and mid
                if ( nums[low] <= target && nums[mid] >= target){
                    high = mid-1;
                } else {
                    low = mid+1;
                }

            } else { // means right half is sorted
                if ( nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
