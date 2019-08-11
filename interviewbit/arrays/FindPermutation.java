package interviewbit.arrays;

import java.util.ArrayList;

public class FindPermutation {
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = B;
        int min = 1;
        for ( int i=0; i<A.length(); i++){
            if ( A.charAt(i)=='D'){
                result.add(max--);
            }
            else {
                result.add(min++);
            }
        }
        result.add(min);
        return result;
    }
}
