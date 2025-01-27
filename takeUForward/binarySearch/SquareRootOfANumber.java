package takeUForward.binarySearch;

public class SquareRootOfANumber {
    public static int sqrtN(long N) {
        if ( N == 0 || N == 1) return (int)N;
        long ans = 1;
        long low = 1, high = N;
        while ( low <= high ){
            long mid = low + (high-low)/2;
            if ( mid <= N/mid){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (int)ans;
    }
}
