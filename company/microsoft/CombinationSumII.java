package company.microsoft;

import java.util.ArrayList;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        dfs(a, 0, b, path, combinations);
        return combinations;
    }

    private void dfs(ArrayList<Integer> a, int cur, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> combinations) {
        if(target==0){
            combinations.add(new ArrayList<>(path));
        }
        if(target<0){
            return;
        }
        for(int i= cur; i<a.size(); i++){
            if(i> cur && a.get(i)==a.get(i-1)) continue;
            path.add(path.size(), a.get(i));
            dfs(a, i+1, target-a.get(i), path, combinations);
            path.remove(path.size()-1);
        }
    }
}
