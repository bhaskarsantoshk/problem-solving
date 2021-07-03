package data_structures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        Arrays.sort(nums);
        int startIndex = 0, endIndex = 0;
        for ( int i=0; i<nums.length; i++){
            startIndex = 0;
            if ( i > 0 && nums[i] == nums[i-1]){
                startIndex = endIndex+1;
            }
            endIndex = subsets.size()-1;

            for ( int j= startIndex; j<= endIndex; j++){
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
