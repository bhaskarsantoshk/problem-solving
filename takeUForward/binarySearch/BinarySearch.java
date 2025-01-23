package takeUForward.binarySearch;

public class BinarySearch {
    public static int search(int []nums, int target) {
        int low = 0, high = nums.length-1;
        while ( low <= high){
            int mid = (low + high)/2;
            if ( nums[mid] == target) return mid;
            else if ( nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    public static int searchRec(int[] nums, int target){
        return search(nums, 0, nums.length-1, target);
    }

    private static int search(int[] nums, int low, int high, int target) {
        if ( low > high) return -1;
        int mid = (low + high)/2;
        if ( nums[mid] == target) return mid;
        else if ( nums[mid] > target) return search(nums, low, mid-1, target);
        else return search(nums, mid+1, high, target);
    }
}
