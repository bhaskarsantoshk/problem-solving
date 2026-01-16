package takeUForward.plus.BinarySearch.LogicBuilding;

public class FloorAndCeilInSortedArray {
    public int[] getFloorAndCeil(int[] nums, int x) {
        return new int[] { getFloor(nums, x), getCeil(nums, x)};
    }

    private int getCeil(int[] nums, int x) {
       int start = 0, end = nums.length-1;
       int ceil = nums.length;
       while ( start <= end){
           int mid = start + (end-start)/2;
           if ( nums[mid] >= x){
               ceil = mid;
               end = mid-1;
           } else {
               start = mid+1;
           }
       }
        return ceil != nums.length ? nums[ceil]: -1;
    }

    private int getFloor(int[] nums, int x) {
        int start = 0, end = nums.length-1;
        int floor = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( nums[mid] <= x){
                floor = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return floor != -1 ? nums[floor] : -1;
    }
}
