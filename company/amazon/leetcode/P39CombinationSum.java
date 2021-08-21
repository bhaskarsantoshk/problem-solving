package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int remain, ArrayList<Integer> tempList, int start) {
        if (remain < 0){
            return;
        } else if ( remain == 0){
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i=start; i<candidates.length; i++){
                tempList.add(candidates[i]);
                backtrack(res, candidates, remain-candidates[i], tempList, i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
