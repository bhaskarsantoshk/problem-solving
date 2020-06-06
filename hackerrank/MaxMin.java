import java.util.*;

public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Arrays.parallelSort(arr);
        int res = Integer.MAX_VALUE;
        for ( int i=0; i<arr.length-k+1; i++) {
            res = Math.min( res, arr[i+k-1]-arr[i]);
        }
        return res;
    }
  }
