package bytebybyte;

import java.util.Arrays;
import java.util.HashMap;

public class ZeroSumSubArray {
    public int[] zeroSum(int[] arr){
        if ( arr == null || arr.length == 0) return null;
        HashMap<Integer, Integer> sums = new HashMap<>();
        int sum = 0;
        for ( int i=1; i<=arr.length ; i++){
            Integer oldIndex = sums.get(sum);
            if ( oldIndex == null && i == arr.length ){
                return null;
            }
            else if (oldIndex == null){
                sums.put(sum, i);
                sum+=arr[i];
            }
            else{
                return Arrays.copyOfRange(arr, oldIndex, i);
            }
        }
        return null;
    }

}

// brute force: all sub arrays = O(N^2)
// sum all elements and store cumulative sums - if sum which already exists comes - that means - we have zero sum subarray
