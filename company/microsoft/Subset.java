package company.microsoft;

import java.util.*;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Collections.sort(a);
        backtrack(result,new ArrayList<Integer>(),  a, 0);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> tempList, ArrayList<Integer> a, int start) {

        result.add(new ArrayList<>(tempList));
        for(int i=start; i<a.size(); i++){
            tempList.add(a.get(i));
            backtrack(result, tempList, a, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
