package company.microsoft;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final int[] A) {
        int count = 1;
        int majorityElement = A[0];
        for ( int i=1; i<A.length; i++){
            if ( A[i] == majorityElement ){
                count++;
            } else {
                count--;
            }
            if ( count == 0 ){
                majorityElement = A[i];
                count=1;
            }
        }
        
        return majorityElement;
    }
}
