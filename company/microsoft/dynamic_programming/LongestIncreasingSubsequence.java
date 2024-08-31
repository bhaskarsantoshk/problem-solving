package company.microsoft.dynamic_programming;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    int max = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        backtrack(nums, nums.length-1, new ArrayList<Integer>());
        return max;
    }

    private void backtrack(int[] nums, int index, ArrayList<Integer> list) {
        if ( index <= 0) {
            return;
        }

        if ( list.isEmpty() || list.get(list.size()-1) > nums[index]){
            list.add(nums[index]);
            max = Math.max(max, list.size());
            backtrack(nums, index-1, list);
        }
        list.removeLast();
        backtrack(nums, index-1, list);
    }
}
