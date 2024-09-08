package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class L8CombinationSumRecursion {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, 0, candidates.length, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int index, int n, int target,
                                    ArrayList<Integer> list, List<List<Integer>> result) {
        if ( index >= n){
            if ( target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if ( target >= candidates[index]){
            list.add(candidates[index]);
            combinationSum(candidates, index, n, target-candidates[index], list, result);
            list.remove(list.size()-1);
        }
        combinationSum(candidates, index+1, n, target, list, result);
    }
}
