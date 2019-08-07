package interviewbit.backtracking;

import java.util.ArrayList;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(A, 0,result);
        return result;
    }

    private void backtrack(ArrayList<Integer> a, int index, ArrayList<ArrayList<Integer>> result) {
        if ( index >= a.size()){
            result.add(clone(a));
            return;
        }
        for ( int i= index; i<a.size(); i++){
            swap(a, i, index);
            backtrack(a, index+1, result);
            swap(a, index, i);
        }
    }

    private void swap(ArrayList<Integer> a, int i, int index) {
        int temp= a.get(i);
        a.set(i, a.get(index));
        a.set(index, temp);
    }


    private ArrayList<Integer> clone(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        for ( Integer num: a){
            result.add(num);
        }
        return result;
    }
}
