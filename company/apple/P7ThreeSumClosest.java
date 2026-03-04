package company.apple;

import java.util.Arrays;

public class P7ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for ( int i=0; i<nums.length-2; i++){
            int j = i+1, k= nums.length-1;
            while ( j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total == target) return target;
                else if (total > target) {
                    if ( Math.abs(total-target)  < minDiff){
                        minDiff = Math.abs(total-target);
                        result = total;
                    }
                    k--;
                } else {
                    if ( Math.abs(total-target)  < minDiff){
                        minDiff = Math.abs(total-target);
                        result = total;
                    }
                    j++;
                }
            }
        }
        return result;
    }
}
