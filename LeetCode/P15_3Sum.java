package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for ( int i = 0; i < nums.length-2 ; i++){
            if ( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start < end) {
                if ( nums[i] +nums[start] + nums[end] == 0 ) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start-1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end+1]){
                        end--;
                    }
                } else if (nums[i] > nums[start] + nums[end]) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
