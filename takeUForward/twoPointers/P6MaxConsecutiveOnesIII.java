package takeUForward.twoPointers;

public class P6MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        // return longestSubStringWithAtMostKZerosBruteForce(nums, k);
        return longestSubStringWithAtMostKZerosSlidingWindow(nums, k);
    }

    private int longestSubStringWithAtMostKZerosBruteForce(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            int zeros=0;
            for ( int j=i; j<n; j++){
                if ( nums[j] == 0) zeros++;
                if ( zeros <= k) maxLen = Math.max(maxLen, j-i+1);
                else break;
            }
        }
        return maxLen;
    }

    private int longestSubStringWithAtMostKZerosSlidingWindow(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        int left =0, right =0, zeros=0;
        while ( right < n){
            if ( nums[right] == 0) zeros++;
            while ( zeros>k){
                if ( nums[left] == 0) zeros--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
