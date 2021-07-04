package data_structures.arrays;

public class MinimumDifference {
    public static int NumberWithMinDifferenceWithKey ( int a[], int key ){
        int start = 0;
        int end = a.length-1;
        int minDiff = Integer.MAX_VALUE;
        int res = -1;
        while ( start <= end ){
            int mid = start + (end-start)/2;
            if ( a[mid] == key ){
                return a[mid];
            } else if ( a[mid] > key ){
                end = mid-1;
            } else {
                start = mid+1;
            }
            if ( minDiff > Math.abs(a[mid]-key)){
                minDiff = Math.abs(a[mid]-key);
                res = a[mid];
            }
        }
        return res;
    }
}
