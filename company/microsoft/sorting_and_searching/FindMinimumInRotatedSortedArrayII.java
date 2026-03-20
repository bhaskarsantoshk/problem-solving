package company.microsoft.sorting_and_searching;

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while ( start <= end){
            int mid = start + (end-start)/2;
            // 4 5 6 7 8 9 1 2 3
            if ( nums[start] < nums[mid]){
                ans = Math.min(ans, nums[start]);
                start = mid+1;
            } else if ( nums[start] > nums[mid]){
                // 8 9 1 2 3
                ans = Math.min(ans, nums[mid]);
                end = mid-1;
            } else {
                ans = Math.min(ans, nums[start]);
                start++;
            }
        }
        return ans;
    }
}

