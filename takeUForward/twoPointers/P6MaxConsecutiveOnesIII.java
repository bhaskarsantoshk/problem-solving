package takeUForward.twoPointers;

public class P6MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        return longestSubStringWithAtMostKZerosBruteForce(nums, k);
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
}
