package LeetCode.company.microsoft.binarysearch;

public class SquareRoot {
    public int sqrt(int A) {
        if ( A == 0 ) return 0;
        int start = 1, end = A;
        int ans = 0;
        while ( start <= end ){
            int mid = start + ( end - start)/2;
            if ( mid  == A/mid ){
                return mid;
            } else if ( mid > A/mid ){
                end = mid-1;
            } else {
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
}
