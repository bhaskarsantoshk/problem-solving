package company.microsoft;

public class LongestSubarrayWithMaxSumK {
    public int longestSubArrayWithMaxKSum(int [] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        int sum = 0;
        int left = 0, right = 0;
        while ( right < n){
            sum += arr[right];
            while ( sum > k){
                sum -= arr[left];
                left++;
            }
            if ( sum <= k) maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
