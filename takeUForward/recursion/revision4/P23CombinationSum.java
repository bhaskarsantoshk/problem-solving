package takeUForward.recursion.revision4;

import java.util.ArrayList;
import java.util.List;

public class P23CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target, int index, List<List<Integer>> result, ArrayList<Integer> current) {
        if ( target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if ( index == candidates.length || target < 0) return;
        current.add(candidates[index]);
        combinationSum(candidates, target-candidates[index],index,  result, current);
        current.remove(current.size()-1);
        combinationSum(candidates, target,index+1,  result, current);
    }


}
