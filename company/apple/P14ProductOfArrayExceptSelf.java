package company.apple;

import java.util.Arrays;

public class P14ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int []prefix = new int[nums.length];
        Arrays.fill(prefix, 1);
        int []suffix = new int[nums.length];
        Arrays.fill(suffix, 1);
        for ( int i=1; i <nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for ( int i=nums.length-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        int[] res = new int[nums.length];
       for ( int i=0; i<nums.length; i++){
           res[i] = prefix[i] * suffix[i];
       }
       return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int []prefix = new int[nums.length];
        Arrays.fill(prefix, 1);
        for ( int i=1; i <nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int prod = 1;
        for ( int i=nums.length-2; i>=0; i--){
            prod *= nums[i+1];
            prefix[i] = prefix[i] * prod;
        }

        return prefix;
    }
}
