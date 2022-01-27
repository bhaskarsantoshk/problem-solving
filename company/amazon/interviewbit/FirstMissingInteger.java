package company.amazon.interviewbit;

import java.util.ArrayList;

public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
        // Get all positive numbers to left

        int index = 0;
        for ( int i=0; i<A.size(); i++){
            if ( A.get(i) > 0 ){
                A.set(index++, A.get(i));
            }
        }
        int size = index;
        int res = index+1 ; // Initial assumption if all positive numbers exist

        for ( int i=0; i<size; i++){
            int num = Math.abs(A.get(i));
            if ( num-1 < size ){
                A.set(num-1, -1 * A.get(num-1));
            }
        }

        for ( int num : A){
            if ( num < 0){
                return num-1;
            }
        }
        return res;
    }
}
