package express_prep.amzn.top_voted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if ( nums == null || nums.length <= 2) return res;
        Arrays.sort(nums);
        for ( int i=0; i<nums.length-2; i++){
            if ( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1, end = nums.length-1;
            while ( start < end ){
                if ( nums[i] +nums[start] + nums[end] == 0 ){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[start]);
                    subList.add(nums[end]);
                    res.add(subList);
                    start++;
                    end--;
                    while ( start < end && nums[start] == nums[start-1] ) {
                        start++;
                    }
                    while ( start < end && nums[end] == nums[end+1]) {
                        end--;
                    }
                } else if ( nums[i] + nums[start] + nums[end] > 0){
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }
}
