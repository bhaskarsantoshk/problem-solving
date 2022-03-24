package company.amazon.leetcode;

public class P1567MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int positiveLen = 0, negativeLen = 0;
        int ans = 0;
        for ( int num: nums){
            if ( num == 0){
                positiveLen = 0;
                negativeLen = 0;
            } else if ( num > 0){
                positiveLen ++;
                negativeLen = negativeLen == 0 ? 0: negativeLen+1;
            } else {
                int temp = positiveLen;
                positiveLen = ( negativeLen == 0 ? 0 : negativeLen+1);
                negativeLen = temp+1;
            }
            ans = Math.max(ans, positiveLen);
        }
        return ans;
    }
}
