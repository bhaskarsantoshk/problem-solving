package takeUForward.binarySearch;

import java.util.ArrayList;

// https://www.naukri.com/code360/problems/find-peak-element_1081482?leftPanelTabValue=PROBLEM

public class FindPeakElement {
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size();
        if ( n == 1) return 0;
        if ( arr.get(0) > arr.get(1)) return 0;
        if ( arr.get(n-1) > arr.get(n-2)) return n-1;
        int low = 1, high = n-2;
        while ( low <= high ){
            int mid = ( low + high)/2;
            if ( arr.get(mid) > arr.get(mid-1) && arr.get(mid) > arr.get(mid+1)) return mid;
            else if ( arr.get(mid) > arr.get(mid-1)){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
