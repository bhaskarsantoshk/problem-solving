package interviewbit.arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        transpose(a);
        reverseRows(a);
    }

    private void reverseRows(ArrayList<ArrayList<Integer>> a) {
        for(int i=0;i<a.size();i++){
            reverseArray(a.get(i));
        }
    }

    private void reverseArray(ArrayList<Integer> integers) {
        for(int i=0;i<integers.size()/2;i++){
            int temp = integers.get(i);
            integers.set(i, integers.get(integers.size()-1-i));
            integers.set(integers.size()-1-i, temp);
        }
    }

    private void transpose(ArrayList<ArrayList<Integer>> a) {
        for(int i=0;i<a.size();i++){
            for(int j=i;j<a.get(0).size();j++){
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(j).get(i));
                a.get(j).set(i, temp);
            }
        }
    }

}
