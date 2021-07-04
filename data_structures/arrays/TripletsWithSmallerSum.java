package data_structures.arrays;

import java.util.Arrays;
import java.util.List;

public class TripletsWithSmallerSum {
    public static int getTripletsWithSmallerSum(int[] nums, int targetSum){
        if ( nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for ( int i=0; i<nums.length-2; i++){
            int start = i+1, end = nums.length-1;
            while ( start < end ){
                int sum = nums[i] + nums[start]+ nums[end];
                if ( sum < targetSum){
                    res+= (end-start);
                    start++;
                } else{
                    end--;
                }
            }
        }
        return res;
    }
}
