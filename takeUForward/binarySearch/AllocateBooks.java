package takeUForward.binarySearch;

import java.util.ArrayList;

public class AllocateBooks {
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if ( m > n) return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for ( Integer num: arr){
            low = Math.max(low, num);
            high += num;
        }
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( numOfStudents(arr, mid) > m){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    private static int numOfStudents(ArrayList<Integer> arr, int maxPages){
        int countStudents = 1;
        int pages = 0;
        for ( int i=0; i<arr.size(); i++){
            if ( pages + arr.get(i) <= maxPages ){
                pages += arr.get(i);
            } else {
                countStudents++;
                pages = arr.get(i);
            }
        }
        return countStudents;
    }
}
