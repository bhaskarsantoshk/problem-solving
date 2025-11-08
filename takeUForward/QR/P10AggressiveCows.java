package takeUForward.QR;

import java.util.Arrays;

public class P10AggressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 1 , end = nums[n-1]-nums[0];
        for ( int i=start; i<=end; i++){
            if ( canWePlaceCowsAtDistanceD(nums, i, k)){
                continue;
            } else return i-1;
        }
        return n;
    }

    private boolean canWePlaceCowsAtDistanceD(int[] nums, int distance, int k) {
        int count = 1, last = nums[0];

        for ( int i=1; i<nums.length; i++){
            if ( nums[i]-last >= distance) {
                last = nums[i];
                count++;
            }
        }
        return count >= k;
    }

    public int aggressiveCowsBinarySearch(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 1 , end = nums[n-1]-nums[0];
        while ( start <= end){
            int mid = (start+end)/2;
            if ( canWePlaceCowsAtDistanceD(nums, mid, k)) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start-1;
    }


}
