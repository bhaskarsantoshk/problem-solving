package takeUForward.plus.BinarySearch.LogicBuilding;

public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{ getFirst(nums, target), getLast(nums, target)};
    }

    private int getLast(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int res = -1;
        while ( start <= end ){
            int mid = start + ( end -start)/2;
            if ( nums[mid] == target){
                res = mid;
                start = mid+1;
            } else if ( nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return res;
    }

    private int getFirst(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int res = -1;
        while ( start <= end ){
            int mid = start + ( end -start)/2;
            if ( nums[mid] == target){
                res = mid;
                end = mid-1;
            } else if ( nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return res;
    }
}
