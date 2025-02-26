package takeUForward.blind75.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);
        int[] postfix = new int[n];
        Arrays.fill(postfix, 1);
        for ( int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for ( int i=n-2; i>=0; i--){
            postfix[i] = postfix[i+1]* nums[i+1];
        }
        int[] res = new int[n];
        for ( int i=0; i<n; i++){
            res[i] = prefix[i]*postfix[i];
        }
        return res;
    }

    public int[] productExceptSelfSpaceOptimized(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);
        for ( int i=1; i<n; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int prod = 1;
        for ( int i=n-2; i>=0; i--){
            prod *= nums[i+1];
            prefix[i] = prod* prefix[i];
        }
        return prefix;
    }
}
