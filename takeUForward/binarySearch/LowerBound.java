package takeUForward.binarySearch;

public class LowerBound {
    public static int lowerBound(int []arr, int n, int x) {
        int ans = arr.length;
        int low = 0, high = n-1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr[mid] >= x){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
