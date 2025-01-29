package takeUForward.binarySearch;

public class KthMissingPositiveNumber {
    public static int missingK(int[] vec, int n, int k) {
        int low = 0, high = n-1;

        while ( low <= high ){
            int mid = low + (high-low)/2;
            int missing = vec[mid] - (mid+1);
            if ( missing < k) low = mid+1;
            else high = mid-1;
        }

        return high+1+k;
    }
}
