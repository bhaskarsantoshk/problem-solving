package company.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P6ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);

        for ( int i=0; i<nums.length-2; i++){
            if ( i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while ( j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (total > 0) k--;
                else j++;
            }
        }
        return result;
    }
}
