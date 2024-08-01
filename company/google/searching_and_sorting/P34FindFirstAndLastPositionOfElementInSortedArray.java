package company.google.searching_and_sorting;

public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        boolean isLeft = true;
        int left = findIndex( nums, target, isLeft);
        int right = findIndex(nums, target, false);
        if ( left != -1 && right != -1){
            return new int[]{left, right};
        } else {
            return new int[]{-1,-1};
        }
    }

    private int findIndex(int[] nums, int target, boolean isLeft) {
        int start = 0, end = nums.length-1;
        int ans = -1;
        while ( start <= end){
            int mid = start + (end-start)/2;
            if ( nums[mid] == target ){
                ans = mid;
                if ( isLeft) end = mid;
                else start = mid;
            } else if ( nums[mid] > target){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }
        return ans;
    }
}
