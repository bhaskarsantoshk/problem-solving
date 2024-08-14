package takeUForward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P90SubsetsII {
    public List<List<Integer>> subsetsWithoutDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithoutDup(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void subsetsWithoutDup(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for ( int i= index; i<nums.length; i++){
            if ( i != index && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subsetsWithoutDup(nums, i+1, list, res);
            list.removeLast();
        }
    }
}
