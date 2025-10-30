package takeUForward.QR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an integer array nums. Return all triplets such that:

i != j, i != k, and j != k

nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 One element can be a part of multiple triplets. The output and the triplets can be returned in any order.

 */

public class P1ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while ( left < right){
                if ( nums[i]+ nums[left]+ nums[right] == 0){
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    while ( left > 0 && left < right && nums[left] == nums[left-1]) left++;
                    while ( right < nums.length-1 && left < right && nums[right] == nums[right+1]) right--;
                } else if ( nums[i]+ nums[left]+ nums[right] > 0) right--;
                else left ++;
            }
        }
        return res;
    }
}
