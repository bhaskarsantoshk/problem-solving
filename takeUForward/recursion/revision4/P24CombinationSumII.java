package takeUForward.recursion.revision4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P24CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private void combinationSum2(int[] candidates, int target, int index,
                                 List<List<Integer>> result, ArrayList<Integer> current) {

        if ( target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if ( index == candidates.length || target < 0) return;
        current.add(candidates[index]);
        combinationSum2(candidates, target-candidates[index], index+1, result, current);
        current.remove(current.size()-1);
        for ( int j=index+1; j <candidates.length; j++){
            if(candidates[j] != candidates[index]){
                combinationSum2(candidates, target, j, result, current);
                break;
            }
        }
    }
}
