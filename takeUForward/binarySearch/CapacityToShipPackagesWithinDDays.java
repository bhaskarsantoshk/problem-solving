package takeUForward.binarySearch;

public class CapacityToShipPackagesWithinDDays {
    public static int leastWeightCapacity(int[] weights, int d) {
        int low = 0, high = 0;
        for ( int wt: weights){
            low = Math.max(low, wt);
            high += wt;
        }

        int ans = -1;

        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( numOfDays(weights, mid) <= d){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private static int numOfDays(int[] weights, int capacity){
        int load = 0;
        int days = 1;
        for ( int wt: weights){
            if ( load+wt <= capacity){
                load = load+wt;
            } else {
                load = wt;
                days++;
            }
        }
        return days;
    }
}
