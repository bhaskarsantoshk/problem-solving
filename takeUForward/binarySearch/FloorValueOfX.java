package takeUForward.binarySearch;

public class FloorValueOfX {
    public static int floorSearch(int[] arr, int X, int N) {
        int low = 0, high = N-1, ans = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr[mid] <= X){
                ans = arr[mid];
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}
