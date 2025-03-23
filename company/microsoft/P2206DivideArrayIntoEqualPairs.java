package company.microsoft;

import java.util.HashSet;
import java.util.Set;

public class P2206DivideArrayIntoEqualPairs {
    public boolean divideArray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for ( int num: nums){
            if ( set.contains(num)) set.remove(num);
            else set.add(num);
        }
        return set.isEmpty();
    }
}
