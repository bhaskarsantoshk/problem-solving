package takeUForward.striver79;

import java.util.ArrayList;

public class P10FindMinimumInRotatedSortedArray {
    public int findMinLinearSearch(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for ( int num: arr) min = Math.min(min, num);
        return min;
    }

    // 1 2 3 4 5
    // 4 5 1 2 3

    public int findMinBinarySearch(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int low = 0, high = arr.size()-1;
        while ( low <= high){
            int mid = low + ( high- low)/2;
            if ( arr.get(low) <= arr.get(mid)){
                min = Math.min(min, arr.get(low));
                low = mid+1;
            } else {
                min = Math.min(arr.get(mid), min);
                high = mid-1;
            }
        }
        return min;
    }
}
