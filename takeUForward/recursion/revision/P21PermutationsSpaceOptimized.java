package takeUForward.recursion.revision;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class P21PermutationsSpaceOptimized {

    static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> arr, int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findPermutations(arr, result, 0);
        return result;
    }

    private static void findPermutations(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result, int index) {
       if ( index == arr.size()){
           result.add(new ArrayList<Integer>(arr));
           return;
       }
       for ( int i=index; i<arr.size(); i++){
           swap(arr, i, index);
           findPermutations(arr, result, index+1);
           swap(arr, index, i);
       }
    }
}
