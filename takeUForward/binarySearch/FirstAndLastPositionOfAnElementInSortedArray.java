package takeUForward.binarySearch;

import java.util.ArrayList;

public class FirstAndLastPositionOfAnElementInSortedArray {
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int lowerBound = getLowerBound(arr, n, k);
        int upperBound = getUpperBound(arr, n, k);
        if ( lowerBound == n || arr.get(lowerBound) != k) return new int[] {-1,-1};
        return new int[] {lowerBound, upperBound-1};
    }

    private static int getLowerBound(ArrayList<Integer> arr, int n, int k){
        int low = 0, high = n-1, ans = n;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr.get(mid) >= k){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private static int getUpperBound(ArrayList<Integer> arr, int n, int k){
        int low = 0, high = n-1, ans = n;
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( arr.get(mid) > k){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}
