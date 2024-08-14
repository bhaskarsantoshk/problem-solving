package takeUForward.recursion;

import java.util.*;

public class P40CombinationSumII {
    public List<List<Integer>> combinationSum2Naive(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> resultSet = new HashSet<>();
        combinationSum2Naive(candidates, 0, target, resultSet, new ArrayList<Integer>());
        List<List<Integer>> result = List.copyOf(resultSet);
        return result;
    }

    private void combinationSum2Naive(int[] candidates, int index, int remain, Set<List<Integer>> resultSet,
                                 ArrayList<Integer> list) {
        if ( remain < 0) return;
        if ( index == candidates.length ) {
            if ( remain == 0) resultSet.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[index]);
        combinationSum2Naive(candidates, index+1, remain-candidates[index], resultSet, list);
        list.removeLast();
        combinationSum2Naive(candidates, index+1, remain, resultSet, list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(0, candidates, target, res, new ArrayList<Integer>());
        return res;
    }

    private void combinationSum2(int index, int[] arr, int remain,
                                     List<List<Integer>> res, ArrayList<Integer> list) {
        if (remain == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for ( int i= index; i<arr.length; i++){
            if ( i>index && arr[i] == arr[i-1]) continue;
            if ( arr[i] > remain) break;

            list.add(arr[i]);
            combinationSum2(i+1, arr, remain-arr[i], res, list);
            list.removeLast();
        }
    }
}
