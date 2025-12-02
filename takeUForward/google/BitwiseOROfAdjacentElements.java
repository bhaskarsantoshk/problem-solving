package takeUForward.google;

import java.util.ArrayList;
import java.util.List;

public class BitwiseOROfAdjacentElements {
    public List<Integer> orArray(List<Integer> A) {
        List<Integer> result = new ArrayList<>();
        for ( int i=0; i<A.size()-1; i++){
            result.add(A.get(i) | A.get(i+1));
        }
        return result;
    }
}
