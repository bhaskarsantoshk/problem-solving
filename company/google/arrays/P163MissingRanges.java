package company.google.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P163MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        // nums[i+1] > nums[i] -> missing range (nums[i]+1, nums[i+1]-1)
        // boundary conditions - if lower < nums[0], missing range [lower, nums[0]-1]
        // if upper > nums[len-1] , missing range nums[len-1]+1, upper

        List<List<Integer>> missingRanges = new ArrayList<>();
        if (nums== null || nums.length == 0 ) {
            missingRanges.add( Arrays.asList(lower, upper));
            return missingRanges;
        }
        if ( lower < nums[0]) missingRanges.add(Arrays.asList(lower, nums[0]-1));
        for ( int i=0; i<nums.length-1; i++){
            if ( nums[i+1]-nums[i] <= 1 ){
                continue;
            }
            missingRanges.add(Arrays.asList(nums[i]+1, nums[i+1]-1));
        }
        if ( upper > nums[nums.length-1]) missingRanges.add(Arrays.asList(nums[nums.length-1]+1, upper));

        return missingRanges;
    }
}
