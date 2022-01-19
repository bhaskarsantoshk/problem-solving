package company.amazon.interviewbit;

import java.util.ArrayList;

public class RoatateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        reverseRows(a);
    }

    private void transpose(ArrayList<ArrayList<Integer>> a){
        for ( int i=0; i<a.size(); i++){
            for ( int j=0; j<i; j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a){
        for ( ArrayList<Integer> row: a){
            reverseElements(row);
        }
    }

    private void reverseElements(ArrayList<Integer> a){
        int start = 0, end = a.size()-1;
        while ( start < end){
            int temp = a.get(start);
            a.set(start++, a.get(end));
            a.set(end--, temp);
        }
    }
}
