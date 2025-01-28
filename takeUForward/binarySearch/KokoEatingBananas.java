package takeUForward.binarySearch;

public class KokoEatingBananas {
    public static int minimumRateToEatBananas(int []v, int h) {
        int high = 0;
        int low = 1;
        for ( int num: v){
            high = Math.max(num, high);
        }
        int ans = -1;

        while ( low <= high ){
            int mid = low + (high-low)/2;

            if ( isPossible(v, h, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] v, int h, int mid){
        int total = 0;
        for ( int num: v){
            total += (int) Math.ceil(((double)num/(double)mid));
        }
        return total <= h;
    }
}
