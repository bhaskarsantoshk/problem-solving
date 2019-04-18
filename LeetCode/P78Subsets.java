package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(nums, list, new ArrayList<Integer>(), 0);
        return list;
    }

    private void backtrack(int[] nums, List<List<Integer>> list, ArrayList<Integer> tempList, int start) {
        list.add(new ArrayList<>(tempList));
        for(int i=start; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, list, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
