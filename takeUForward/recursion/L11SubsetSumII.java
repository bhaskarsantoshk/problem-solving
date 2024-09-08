package takeUForward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L11SubsetSumII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    private void subsetsWithDup(int index, int[] nums, List<List<Integer>> result, ArrayList<Integer> list) {
        result.add(new ArrayList<>(list));

        for ( int i=index; i<nums.length; i++){
            if ( i != index && nums[i] == nums[i-1]) continue; // if there are duplicates, take only for the first time
            list.add(nums[i]);
            subsetsWithDup(i+1, nums, result, list);
            list.remove(list.size()-1);
        }
    }
}
