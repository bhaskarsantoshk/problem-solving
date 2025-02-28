package takeUForward.blind75.arrays;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        // Find the sorted half, the minimum element lies in the unsorted half as it will have the roated point
        // if both halves are sorted - pick the min and eliminate one of the halves

        int ans = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( nums[low] <= nums[mid]){
                // left half is sorted
                ans = Math.min(nums[low], ans);
                low = mid+1;
            } else {
                ans = Math.min(nums[mid], ans);
                high = mid-1;
            }
        }
        return ans;
    }
}
