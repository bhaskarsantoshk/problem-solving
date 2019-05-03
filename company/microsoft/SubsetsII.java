package company.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        backtrack(results,set, new ArrayList<>(), a, 0 );
        return results;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> results,Set<ArrayList<Integer>> set, ArrayList<Integer> tempList, ArrayList<Integer> a, int start) {
        if(!set.contains(tempList)) {
            results.add(new ArrayList<>(tempList));
            set.add(tempList);
        }
        for(int i = start; i<a.size(); i++){
            tempList.add(a.get(i));
            backtrack(results,set, tempList, a, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
