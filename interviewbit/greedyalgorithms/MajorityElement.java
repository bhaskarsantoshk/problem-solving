package interviewbit.greedyalgorithms;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int count = 0;
        int majaorityElement = 0;

        for ( int i=0; i<A.size(); i++){
            if (count == 0){
                majaorityElement = A.get(i);
                count++;
            }
            else {
                if ( majaorityElement == A.get(i)){
                    count++;
                }
                else{
                    count--;
                }
            }
        }

        return majaorityElement;
    }
}
