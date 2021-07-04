package data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

import static Recursion.DataFormatter.swap;

public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(nums, 0, result);
        return result;
    }

    private static void findPermutations(int[] nums, int start, List<List<Integer>> result) {
        if ( start >= nums.length){
            result.add(getClonedList(nums));
        }
        else {
            for ( int i= start ; i<nums.length; i++){
                swap(nums, i, start);
                findPermutations(nums, start+1, result);
                swap(nums, i, start);
            }
        }
    }

    private static List<Integer> getClonedList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for ( Integer num: nums){
            list.add(num);
        }
        return list;
    }
}
