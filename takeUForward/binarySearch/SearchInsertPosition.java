package takeUForward.binarySearch;

public class SearchInsertPosition {
    public static int searchInsert(int [] arr, int m){
        int low = 0, high = arr.length-1, ans = arr.length;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr[mid] >= m){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
