package takeUForward.plus.BinarySearch.LogicBuilding;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int ans = nums.length;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( nums[mid] >= target){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
}
