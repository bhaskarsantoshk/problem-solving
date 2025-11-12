package takeUForward.QR;

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
        return (a2 <= a1 && d2 >= d1) || (a2 >= a1 && d2 <= d1) || (a2 <= a1 && d2 <=d1) || (a2>=a1 && d2 <= d1);
    }
}
