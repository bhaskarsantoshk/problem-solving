package takeuForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSets {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generate(0, new ArrayList<Integer>(), res, nums, nums.length);
        return res;
    }

    private void generate(int i, ArrayList<Integer> list, List<List<Integer>> res, int[] nums, int length) {
        if ( i >= length) {
            res.add(new ArrayList<>(list)); // Do not just add list
            return;
        }
        list.add(nums[i]);
        generate(i+1, list, res, nums, length);
        list.remove(list.size()-1); //list.removeLast();
        generate(i+1, list, res, nums, length);
    }


}
