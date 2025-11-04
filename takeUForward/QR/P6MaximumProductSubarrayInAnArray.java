package takeUForward.QR;

public class P6MaximumProductSubarrayInAnArray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            if (prefix == 0) prefix=1;
            if ( suffix == 0) suffix=1;
            if ( nums[i] > 0 && prefix > Integer.MAX_VALUE/ nums[i] ) break;
            if ( nums[n-i-1] > 0 && suffix > Integer.MAX_VALUE/ nums[n-i-1]) break;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            max = Math.max(max, Math.max(suffix, prefix));
        }
        return max;
    }
}
