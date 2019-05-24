package LeetCode;

import java.util.Arrays;

public class P910SmallestRangeII {
    public int smallestRangeII(int[] a, int k) {
        Arrays.sort(a);
        int min = a[0];
        int max = a[a.length-1];
        int diff = max - min;
        for(int i=0; i< a.length-1 ; i++){
            max = Math.max ( a[i] + 2 * k , max);
            min = Math.min (min, a[0]+2*k);
            diff = Math.min ( max-min, diff);
        }
        return diff;
    }
}
