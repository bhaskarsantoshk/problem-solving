package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.swap;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for ( int i=0; i<A.size()-1; i+=2){
            swap(A, i, i+1);
        }
        return A;
    }
    private void swap (ArrayList<Integer> A, int i, int j){
        int temp = A.get(i);
        A.set ( i, A.get(j));
        A.set(j, temp);
    }
}
