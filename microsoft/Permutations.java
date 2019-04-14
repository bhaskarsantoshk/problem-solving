package microsoft;

import java.util.ArrayList;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        permutations(a, 0, results);
        return results;
    }

    private void permutations(ArrayList<Integer> a, int start, ArrayList<ArrayList<Integer>> results) {
        if(start>= a.size()){
            results.add(cloneList(a));
        }
        else {
            for (int i = start; i<a.size(); i++){
                swap(a, start , i);
                permutations(a, start+1, results);
                swap(a, start , i);
            }
        }
    }

    private void swap(ArrayList<Integer> a, int i , int j){
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    public static ArrayList<Integer> cloneList(ArrayList<Integer> list) {
        ArrayList<Integer> clone = new ArrayList<Integer>(list.size());
        for (Integer item : list) clone.add(item);
        return clone;
    }
}
