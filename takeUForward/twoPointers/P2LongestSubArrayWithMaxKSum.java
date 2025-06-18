package takeUForward.twoPointers;

public class P2LongestSubArrayWithMaxKSum {
    public int longestSubArrayWithMaxKSum(int [] arr, int k){
        int n = arr.length;
        int maxLen =0;
        int l=0, r=0;
        int sum =0;
        while ( r < n){
            sum+= arr[r];
            while ( sum >= k){
                sum -= arr[l];
                l++;
            }
            if (sum <=k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
