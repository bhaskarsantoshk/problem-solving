package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int start, int[] nums) {
        if(start <= nums.length){
            result.add(cloneList(nums));
        }
        for(int i=start; i<nums.length; i++){
            swap(nums, start, i);
            backtrack(result, start+1, nums);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> cloneList(int[] nums) {
        ArrayList<Integer> clone = new ArrayList<Integer>(nums.length);
        for (Integer item : nums) clone.add(item);
        return clone;
    }
}
