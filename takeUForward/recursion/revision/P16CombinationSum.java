package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.List;

public class P16CombinationSum {
    public static List<List< Integer >> combSum(int []candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombinations(int[] candidates, int index, int target, List<List<Integer>> ans,
                                         ArrayList<Integer> list) {
        if ( index == candidates.length){
            if ( target == 0){
                ans.add(new ArrayList<>(list)); // o(k)
            }
            return;
        }
        if ( candidates[index] <= target) {
            list.add(candidates[index]);
            findCombinations(candidates, index, target - candidates[index], ans, list); // 2^t
            list.remove(list.size() - 1);
        }
        findCombinations(candidates, index+1, target, ans, list);
    }
}
// T: O(K * 2^T)
// S: O(K*X)

// https://www.naukri.com/code360/problems/combination-sum_981296?leftPanelTabValue=PROBLEM
