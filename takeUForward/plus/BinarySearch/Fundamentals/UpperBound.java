package takeUForward.plus.BinarySearch.Fundamentals;

public class UpperBound {
    public int upperBound(int[] nums, int x) {
        int start = 0, end = nums.length-1;
        int res = nums.length;
        while ( start <= end ){
            int mid = start + (end-start)/2;
            if ( nums[mid] <= x){
                start = mid+1;
            } else {
                res = mid;
                end = mid-1;
            }
        }
        return res;
    }
}
