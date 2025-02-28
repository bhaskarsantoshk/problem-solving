package takeUForward.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        int n = nums.length;
        for ( int i=0; i<nums.length-2; i++){
           if ( i != 0 && nums[i] == nums[i-1]) continue;
           int j= i+1;
           int k = n-1;
           while ( j < k){
               int sum = nums[i]+nums[j]+nums[k];
               if ( sum < 0){
                   j++;
               } else if ( sum > 0){
                   k--;
               } else {
                   List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                   res.add(temp);
                   j++;k--;
                   while ( j < k && nums[j] == nums[j-1]) j++;
                   while ( j < k && nums[k] == nums[k+1]) k--;
               }
           }
        }
        return res;
    }
}
