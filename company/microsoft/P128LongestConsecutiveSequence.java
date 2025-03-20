package company.microsoft;

import java.util.HashSet;
import java.util.Set;

public class P128LongestConsecutiveSequence {
    public int longestConsecutiveBruteForce(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for ( int num: nums) set.add(num);
        for ( int num: set){
            int count = 0;
            if ( set.contains(num-1)) continue;
            while ( set.contains(num++)){
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
