package takeUForward.recursion.revision2;

import java.util.ArrayList;
import java.util.List;

public class P13PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void generate(int[] nums, int i,List<List<Integer>> result, ArrayList<Integer> list) {
        if ( i >= nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        generate(nums, i+1, result, list);
        list.remove(list.size()-1);
        generate(nums, i+1, result, list);
    }
}
