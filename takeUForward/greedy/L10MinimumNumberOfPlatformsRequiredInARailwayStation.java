package takeUForward.greedy;

import java.util.Arrays;

public class L10MinimumNumberOfPlatformsRequiredInARailwayStation {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0, j=0;
        int count = 0;
        int max = 0;
        while ( i < arr.length && j <dep.length){
            if ( arr[i] < dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            max = Math.max( max, count);
        }
        return max;
    }
}
