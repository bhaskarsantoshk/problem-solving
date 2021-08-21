package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if ( nums == null || nums.length == 0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int start, int[] nums) {
        if ( start >= nums.length){
            res.add(cloneList(nums));
        }
        for (int i=start; i<nums.length; i++){
            swap(nums, i, start);
            backtrack(res, start+1, nums);
            swap(nums, start, i);
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private List<Integer> cloneList(int[] nums) {
        List<Integer> clone = new ArrayList<>();
        for ( int num: nums){
            clone.add(num);
        }
        return clone;
    }
}
