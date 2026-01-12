package takeUForward.plus.BinarySearch.Fundamentals;

public class SearchXInSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = 0;
        while ( start < end){
            int mid = start + (end-start)/2;
            if ( nums[mid] == target) return mid;
            else if ( nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}
