package interviewbit.arrays;

import java.util.List;

public class MaxDistance {
    public int maximumGap(final List<Integer> A) {
        int lMin[] = new int[A.size()];
        int rMax[] = new int[A.size()];
        lMin[0] = A.get(0);
        for ( int i=1; i<A.size(); i++){
            lMin[i] = Math.min (lMin[i-1], A.get(i));
        }
        rMax[A.size()-1] = A.get(A.size()-1);
        for ( int i= A.size()-2; i>=0; i--){
            rMax[i] = Math.max(rMax[i+1], A.get(i));
        }
        int i= 0, j=0, maxDiff = -1;
        while ( i < A.size() && j < A.size()){
            if ( lMin[i] <= rMax[j]){
                maxDiff = Math.max ( maxDiff, j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return maxDiff;
    }
}
