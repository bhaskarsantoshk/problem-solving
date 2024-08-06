package company.google;
import java.util.ArrayList;
import java.util.List;

public class P39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private void findCombinations(int[] candidates, List<List<Integer>> res, ArrayList<Integer> tempList, int remain, int start) {
        if ( start == candidates.length){
            if ( remain == 0) res.add(new ArrayList<>(tempList));
            return;
        }
        if ( candidates[start] <= remain){
            tempList.add(candidates[start]);
            findCombinations(candidates, res, tempList, remain-candidates[start], start);
            tempList.removeLast();
        }
        findCombinations(candidates, res, tempList, remain, start+1);
    }
}
