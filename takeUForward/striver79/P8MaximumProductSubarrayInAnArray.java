package takeUForward.striver79;

public class P8MaximumProductSubarrayInAnArray {
    public int maxProductBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for ( int i=0; i<nums.length; i++){
            int prod = 1;
            for ( int j=i; j<nums.length; j++){
                prod *= nums[j];
                max = Math.max(prod, max);
            }
        }
        return max;
    }


    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        for ( int i=0; i<nums.length; i++){
            prefix *= nums[i];
            max = Math.max(max, prefix);
            if ( prefix == 0) prefix = 1;
        }
        int suffix = 1;
        for ( int i=nums.length-1; i>=0; i--){
            suffix *= nums[i];
            max = Math.max(max, suffix);
            if ( suffix == 0) suffix = 1;
        }
        return max;
    }
}
