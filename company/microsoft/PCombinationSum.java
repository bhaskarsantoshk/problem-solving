package company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class PCombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        f(0,0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void f(int i, int sum, int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> list) {
        if ( sum > target) return;
        if ( i >= candidates.length){
            if ( sum == target) result.add(new ArrayList<>(list));
            return;
        }

        list.add(candidates[i]);
        f(i, sum+candidates[i], candidates, target, result, list);
        list.remove(list.size()-1);
        f(i+1, sum, candidates, target, result, list);
    }
}
