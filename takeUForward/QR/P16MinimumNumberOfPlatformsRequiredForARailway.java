package takeUForward.QR;

import java.util.Arrays;

public class P16MinimumNumberOfPlatformsRequiredForARailway {
    public int findPlatform(int[] Arrival, int[] Departure) {
        int max = 0;
        int n = Arrival.length;
        for ( int i=0; i<n; i++){
            int count = 1;
            for ( int j=0; j< n; j++){
                if ( i==j) continue;
                if ( isIntersecting(Arrival[i], Departure[i], Arrival[j], Departure[j])) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private boolean isIntersecting(int a1, int d1, int a2, int d2) {
        return a1 >= a2 && d2 >= a1;
    }

    public int findPlatformOptimized(int[] Arrival, int[] Departure) {
        int max = 0;
        int n = Arrival.length;
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int count=0;
        int i=0, j=0;
        while ( i < n && j < n){
            if ( Arrival[i] <= Departure[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
