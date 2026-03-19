package company.microsoft.sorting_and_searching;

public class FindMinimumInRotatedSortedArray {

    // Find the sorted half, the minimum element lies in the unsorted half as it will have the roated point
    // if both halves are sorted - pick the min and eliminate one of the halves


    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        int low = 0, high = nums.length-1;
        while ( low <= high){
            int mid = low + (high-low)/2;
            // min resides in sorted half typically, if both halves are sorted, pick min and eliminate one of the halves
            // if left half is sorted, min element can reside on other side ( and can also be nums[low])
            //  4 5 6 0 1 2
            if ( nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid+1;
            } else {
                // if left half is not sorted, the element will reside likely before mid
                // 6 0 1 2 4 5
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}
