package takeUForward.binarySearch;

import java.util.ArrayList;

public class SearchInRotatedSortedArray {
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n-1;

        while ( low <= high ){
            int mid = low + (high -low)/2;
            if ( arr.get(mid) == k) return mid;
            else if ( arr.get(low) <= arr.get(mid)){
                if ( arr.get(low) <= k && arr.get(mid) >= k){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if ( arr.get(mid) <= k && arr.get(high) >= k){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
