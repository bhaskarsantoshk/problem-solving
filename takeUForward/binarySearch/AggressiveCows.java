package takeUForward.binarySearch;

import java.util.Arrays;

public class AggressiveCows {
    
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n-1]-stalls[0];
        int ans = -1;
        while ( low <= high ){
            int mid = low + (high - low)/2;
            if ( canWePlace(stalls, mid, k)){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    private static boolean canWePlace(int [] stalls, int distance, int cows){
        int count = 1, last = stalls[0];
        for ( int i=1; i<stalls.length; i++){
            if ( stalls[i] - last >= distance){
                count++;
                last = stalls[i];
            }
            if ( count >= cows) return true;
        }
        return false;

    }
}
