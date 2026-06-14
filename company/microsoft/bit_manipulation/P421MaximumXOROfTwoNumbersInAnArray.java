package company.microsoft.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class P421MaximumXOROfTwoNumbersInAnArray {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int max = 0;
        for ( int i=0; i<n; i++){
            for ( int j=i+1; j<n; j++){
                max = Math.max( max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    public int findMaximumXORBitManipulation(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int mask = 0;
        for ( int bit=31; bit>=0; bit--){
            mask |= (1 << bit);
            Set<Integer> set = new HashSet<>();
            for ( int num: nums) set.add(num&mask);
            int candidate = ans & ( 1 << bit);

            for ( int p: set){
                if ( set.contains(p ^ candidate)){
                    ans = candidate; break;
                }
            }
        }
        return ans;

    }
}
