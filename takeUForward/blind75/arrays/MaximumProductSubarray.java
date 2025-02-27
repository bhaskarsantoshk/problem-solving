package takeUForward.blind75.arrays;

public class MaximumProductSubarray {
    // Bruteforce
    // generate all sub arrays -> N^3

    // keep a product variable and run two loops -> N^2

    // O (N)

    // Observations
    // ALL +VE -> product of all
    // even -ve -> product of all
    // odd negative -> ignoring one negative -> either prefix or suffix product
    // in all cases - either prefix or suffix is the answer

    // if it has zeros -> max all of sub arrays that are outside zeroes

    public int maxProduct(int[] nums) {
        int prefix = 1, suffix = 1;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            if ( prefix == 0) prefix=1;
            if ( suffix == 0) suffix=1;
            if ( nums[i] > 0 && prefix > Integer.MAX_VALUE/nums[i] ) break;
            if ( nums[i] > 0 && suffix > Integer.MAX_VALUE/ nums[i] ) break;
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            max = Math.max(max, Math.max(suffix, prefix));
        }
        return max;
    }
}
