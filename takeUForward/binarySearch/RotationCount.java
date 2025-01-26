package takeUForward.binarySearch;

public class RotationCount {
    public static int findMinIndex(int []arr) {
        int low = 0, high = arr.length-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while ( low <= high ){
            int mid = low + (high-low)/2;

            if ( arr[low] <= arr[high]){
                if ( ans > arr[low]) {
                    ans = arr[low];
                    index = low;
                    break;
                }
            }

            if ( arr[low] <= arr[mid]){
                if ( ans > arr[low]){
                    ans = arr[low];
                    index = low;
                }
                low = mid+1;
            } else {
                if ( ans > arr[mid]){
                    ans = arr[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }
        return ans;
    }
}
