package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.Collections;

public class P17CombinationSumII {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(arr);
        findCombinations(arr, 0, target, ans, new ArrayList<Integer>());
        return ans;
    }

    private static void findCombinations(ArrayList<Integer> arr, int index, int target, ArrayList<ArrayList<Integer>> ans,
                                         ArrayList<Integer> list) {
        if ( index == arr.size()){
            if ( target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for ( int i = index; i<arr.size(); i++){
            if ( i> index && arr.get(i) == arr.get(i-1)) continue;
            if ( arr.get(i) > target) break;
            list.add(arr.get(i));
            findCombinations(arr, i+1, target-arr.get(i), ans, list);
            list.remove(list.size()-1);
        }
    }
}

// combination sum 1:
// Pseudo-code
//pick => stay at index
//not pick => move to index + 1

// comb sum 2
// for (int i = index; i < arr.size(); i++) {

// In the for-loop:
// We skip picking by not entering the loop for certain elements (like duplicates or elements too big).
// We move forward anyway to the next distinct candidate.
// non pick is handled within
