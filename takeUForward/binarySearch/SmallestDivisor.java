package takeUForward.binarySearch;

// https://www.naukri.com/code360/problems/smallest-divisor-with-the-given-limit_1755882?leftPanelTabValue=PROBLEM

public class SmallestDivisor {
    public static int smallestDivisor(int arr[], int limit) {
        int low = 1;
        int high = 0;
        for ( int num: arr){
            high = Math.max( high, num);
        }
        int ans = -1;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( isPossible(arr, limit, mid) ) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] arr, int limit, int divisor){
        int total = 0;
        for ( int num: arr){
            total += (int) Math.ceil((double)num/(double)divisor);
        }
        return total <= limit;
    }
}
