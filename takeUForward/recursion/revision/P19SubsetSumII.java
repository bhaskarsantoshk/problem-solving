package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.Arrays;

public class P19SubsetSumII {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        findUniqueSubsets(arr, 0, res, new ArrayList<>());
        return res;
    }

    private static void findUniqueSubsets(int[] arr, int index,
                                          ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for ( int i=index; i<arr.length; i++){
            if ( i > index && arr[i] == arr[i-1] ) continue;
            list.add(arr[i]);
            findUniqueSubsets(arr, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
/*
             []
            /  \
         [1]   []
        /   \
     [1,2]  [1]


     every stage here is needed to be added to res. if we wait until index == n ,
     we will only be adding [1.2] and [1] but we need all subsets
     hance we are adding at the beginning of rec without reaching full length
 */
