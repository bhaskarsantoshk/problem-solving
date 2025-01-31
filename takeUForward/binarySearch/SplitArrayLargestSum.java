package takeUForward.binarySearch;

import java.util.ArrayList;

public class SplitArrayLargestSum {
    public static int splitArray(ArrayList<Integer> array, int k) {
        int low =0, high =0;
        for ( Integer num: array){
            low = Math.max( low, num);
            high += num;
        }
        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( numOfSubArrays(array, mid) > k){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int numOfSubArrays(ArrayList<Integer> array, int maxSum){
        int total = 0;
        int countArrays = 1;
        for ( int i=0; i<array.size(); i++){
            if ( total+ array.get(i) <= maxSum){
                total += array.get(i);
            } else {
                total = array.get(i);
                countArrays++;
            }
        }
        return countArrays;
    }
}
