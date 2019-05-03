package company.microsoft;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int count =1, maj_index =0;
        int candidate = A.get(0);

        for(int i=1;i<A.size(); i++){
            if(candidate == A.get(i)){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                candidate = A.get(i);
                maj_index = i;
                count=1;
            }
        }
        return A.get(maj_index);
    }
}
