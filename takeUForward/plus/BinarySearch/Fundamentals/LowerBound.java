package takeUForward.plus.BinarySearch.Fundamentals;

public class LowerBound {
    public int lowerBound(int[] nums, int x) {
        int start = 0, end = nums.length-1;
        int res = nums.length;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( nums[mid] >= x){
                res = mid;
                end = mid-1;
            } else{
               start = mid+1;
            }
        }
        return res;
    }
}
