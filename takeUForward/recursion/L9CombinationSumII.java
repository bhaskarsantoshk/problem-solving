package takeUForward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L9CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2(0, candidates, target, new ArrayList<Integer>(), result );
        return result;
    }

    private void combinationSum2(int index, int[] candidates, int remain,
                                     ArrayList<Integer> list, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for ( int i=index ; i<candidates.length; i++){
            if ( i != index && candidates[i] == candidates[i-1]) continue;
            if ( remain >= candidates[i] ){
                list.add(candidates[i]);
                combinationSum2(i+1, candidates, remain-candidates[i], list, result);
                list.remove(list.size()-1);
            } else return; // next numbers will also not match
        }
    }
}
