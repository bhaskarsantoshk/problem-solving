package company.google.dynamic_programming;

public class P152MaximumProductSubarray {
    public int maxProductBruteForce(int[] nums) {
        long maxProduct = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = i; j < nums.length; j++) {
                if ( nums[i] >0 && prod > Integer.MAX_VALUE/nums[i] ) break;
                prod *= nums[j];
                maxProduct = Math.max(maxProduct, prod);
            }
        }

        return (int)maxProduct;
    }

    // all positive numbers -> final prefix = suffix = max
    // even negative numbers -> final prefix = suffix = max
    // odd negative numbers -> max falls on one of the sides either on left / right to the odd negative
    // zeros - max falls on one of the sub array products outside zero
    public int maxProduct(int[] nums) {
        int prefix = 1, suffix=1;
        if ( nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            if ( prefix == 0) prefix =1;
            if ( suffix == 0) suffix = 1;
            if (nums[i] > 0 && prefix > Integer.MAX_VALUE / nums[i]) break;
            if (nums[i] > 0 && suffix > Integer.MAX_VALUE / nums[i]) break;
            prefix *= nums[i];
            suffix *= nums[nums.length-1-i];
            max = Math.max(max, Math.max(suffix, prefix));
        }
        return max;
    }
}
