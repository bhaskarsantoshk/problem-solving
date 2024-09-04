package takeUForward.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        if ( A.size() < B) return result;

        for ( int i=0; i<B; i++){
            map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
        }
        result.add(map.keySet().size());

        for ( int i=B; i<A.size(); i++){
           int remove = A.get(i-B);
           if ( map.containsKey(remove) && map.get(remove) == 1) map.remove(remove);
           if ( map.containsKey(remove)) {
                map.put(remove, map.get(remove)-1);
           }
           map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
           result.add(map.keySet().size());
        }

        return result;
    }
}
