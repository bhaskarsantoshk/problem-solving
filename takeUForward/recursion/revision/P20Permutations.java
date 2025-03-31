package takeUForward.recursion.revision;

import java.util.ArrayList;

public class P20Permutations {

    static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> arr, int size) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] map = new boolean[arr.size()];
        findPermutations(arr, result, map, new ArrayList<Integer>());
        return result;
    }

    private static void findPermutations(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result,
                                  boolean[] map, ArrayList<Integer> list) {
        if ( list.size() == arr.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for ( int i=0; i<arr.size(); i++){
            if ( !map[i]){
                list.add(arr.get(i));
                map[i] = true;
                findPermutations(arr, result, map, list);
                map[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
