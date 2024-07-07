package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if ( nums == null || nums.length < 3 ) return res;
        Arrays.sort(nums);
        for ( int i=0 ; i< nums.length-2; i++){
            if ( i > 0 && nums[i] > nums[i-1] ) continue;
            int start = i+1, end = nums.length-1;
            while ( start < end ){
                int sum = nums[i] + nums[start] + nums[end];
                if ( sum == 0){
                    res.add( Arrays.asList(nums[i], nums[start], nums[end]));
                    while ( start < end && nums[start] == nums[start-1]) start++;
                    while ( start < end && nums[end] == nums[end+1]) end--;
                } else if ( sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }
}
