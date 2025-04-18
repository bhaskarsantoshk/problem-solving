package takeUForward.binarySearch;

// https://www.naukri.com/code360/problems/rotated-array_1093219?leftPanelTabValue=PROBLEM

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int []arr) {
        int low = 0, high = arr.length-1;
        int ans = Integer.MAX_VALUE;

        while ( low <= high ){
            int mid = low + (high-low)/2;

            // optimized
            // if the search space is already sorted, arr[low] will be the smallest in that search space
            if ( arr[low] <= arr[high]){
                ans = Math.min(ans, arr[low]);
                break;
            }

            if ( arr[low] <= arr[mid] ){
                ans = Math.min( ans, arr[low]);
                low = mid+1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}
