package takeUForward.slidingWindow;

public class P12BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result =0;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            for ( int j=i; j<n; j++){
                int sum = 0;
                for ( int k=i; k<=j; k++){
                    sum += nums[k];
                }
                if ( sum == goal) result++;
            }
        }
        return result;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int result =0;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            int sum = 0;
            for ( int j=i; j<n; j++){
                sum += nums[j];
                if ( sum == goal) result++;
            }
        }
        return result;
    }

    public int numSubarraysWithSumOptimal(int[] nums, int goal) {
       return numSubarraysWithSumLessThanOrEqualToK(nums, goal) - numSubarraysWithSumLessThanOrEqualToK(nums, goal-1);
    }

    private int numSubarraysWithSumLessThanOrEqualToK(int[] nums, int k) {
        if ( k < 0) return 0;
        int left = 0, right =0;
        int n = nums.length;
        int count = 0;
        int sum = 0;
        while ( right < n){
            sum+= nums[right];
            while ( sum > k){
                sum -= nums[left];
                left++;
            }
            if ( sum <= k) count+=(right-left+1);
            right++;
        }
        return count;
    }
}
