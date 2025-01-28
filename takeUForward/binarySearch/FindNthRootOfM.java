package takeUForward.binarySearch;

public class FindNthRootOfM {
    public static int NthRoot(int n, int m) {
        if ( n == 0) return 0;

        int low = 1, high = m;
        while ( low <= high ){
            int mid = low + (high-low)/2;

            if ( power(mid, n) == m) return mid;
            else if ( power(mid, n) > m) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    private static int power(int n, int k){
        return (int)Math.pow(n, k);
    }
}
