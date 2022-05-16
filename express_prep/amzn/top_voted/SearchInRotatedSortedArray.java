package express_prep.amzn.top_voted;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while ( start <= end ){
            int mid = (start+end)/2;
            if ( nums[mid] == target ) return mid;
            if ( nums[start] <= nums[mid] ){
                if ( target < nums[mid] && target >= nums[start]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if ( target > nums[mid] && target <= nums[end] ){
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}

// 1 2 3 4 5 6 7
// 6 7 1 2 3 4 5
