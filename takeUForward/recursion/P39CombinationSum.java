package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class P39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, 0, 0, target, res, new ArrayList<Integer>());
        return res;
    }

    private void combinationSum(int[] candidates, int index, int sum, int target,
                                List<List<Integer>> res, List<Integer> list) {
        if ( sum > target) return;
        if ( index >= candidates.length) {
            if ( sum == target) res.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[index]);
        combinationSum(candidates, index, sum+candidates[index], target, res, list );
        list.removeLast();
        combinationSum(candidates, index+1, sum, target, res, list);
    }
}
