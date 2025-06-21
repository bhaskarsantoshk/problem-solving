package takeUForward.slidingWindow;

public class P14CountNumberOfNiceSubarrays {
    public int numberOfOddSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for ( int i=0; i<n; i++){
            int odds = 0;
            for ( int j=i; j<n; j++){
                if ( nums[j] % 2 == 1) odds++;
                if ( odds == k) count++;
            }
        }
        return count;
    }

    public int numberOfOddSubarraysOptimal(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int left=0, right = 0;
        int odds = 0;
        while ( right < n){
            odds += nums[right]%2;
            while ( odds > k){
                odds -= (nums[left]%2);
                left++;
            }
            if ( odds <= k) count+= (right-left+1);
            right++;
        }
        return count;
    }
}
