package company.apple;

import java.util.ArrayList;
import java.util.List;

public class P34CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        f(0, 0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void f(int index, int sum, int[] candidates, int target, ArrayList<Integer> cur, List<List<Integer>> result) {
        if ( sum > target) return;
        if ( index >= candidates.length){
            if ( sum == target){
                result.add(new ArrayList<>(cur));
            }
            return;
        }

        cur.add(candidates[index]);
        f(index, sum+candidates[index], candidates, target, cur, result);
        cur.remove(cur.size()-1);
        f(index+1, sum, candidates, target, cur, result);
    }
}
