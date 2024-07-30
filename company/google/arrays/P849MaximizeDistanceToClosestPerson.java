package company.google.arrays;

public class P849MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int maxDistance = 0;
        int n = seats.length;
        for ( int right = 0; right < n; right++){
            if ( seats[right] == 1){
                if ( left == -1) {
                    // this means we can sit at 0th index;
                    maxDistance = right;
                } else {
                    maxDistance = Math.max( maxDistance, (right-left)/2);
                }
                left = right;
            }
        }
        if ( seats[n-1] == 0){
            maxDistance = Math.max ( maxDistance, n-1-left);
        }
        return maxDistance;
    }
}
