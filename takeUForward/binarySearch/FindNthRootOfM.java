package takeUForward.binarySearch;

public class FindNthRootOfM {
    public static int NthRoot(int n, int m) {
        if ( n == 0) return 0;

        int low = 1, high = m;
        while ( low <= high ){
            int mid = low + (high-low)/2;

            if ( computePower(mid, n, m) == 1) return mid;
            else if ( computePower(mid, n, m) == 2) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    // private static int power(int n, int k){
    //     return (int)Math.pow(n, k);
    // }

    // return 1 if power == m
    // return 0 if < m
    // return 2 if > m
    private static int computePower(int mid, int n, int m){
        long ans = 1;
        for ( int i=1; i<=n; i++){
            ans = ans * mid;
            if ( ans > m) return 2;
        }
        if ( ans == m) return 1;
        return 0;
    }
}
