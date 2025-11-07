package takeUForward.QR;

public class P9KokoEatingBananas {
    public int minimumRateToEatBananas(int[] nums, int h) {
        int low = 1, high = 1;
        for ( int num: nums) high = Math.max(high, num);
        for ( int i=low; i<=high; i++){
            if ( canKokoEatAll(nums, i, h)) return i;
        }
        return -1;
    }


    public int minimumRateToEatBananasBinarySearch(int[] nums, int h) {
        int low = 1, high = 1;
        for ( int num: nums) high = Math.max(high, num);
        while ( low <= high){
            int mid = (low+high)/2;
            if ( canKokoEatAll(nums, mid, h)) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private boolean canKokoEatAll(int[] nums, int i, int h) {
        int hours = 0;
        for (int num: nums){
            hours += Math.ceil((double) num/ i);
        }
        return hours<=h;
    }
}
