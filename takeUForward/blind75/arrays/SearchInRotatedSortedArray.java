package takeUForward.blind75.arrays;

public class SearchInRotatedSortedArray {
    // Identify the sorted half - left / right

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int ans = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( nums[mid] == target) return mid;
            // check if left half is sorted
            if ( nums[low] <= nums[mid]) {
                // check if the target is in the left half
                if ( nums[low] <= target && nums[mid] >= target){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if ( nums[mid] <= target && nums[high] >= target){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return ans;
    }
}
