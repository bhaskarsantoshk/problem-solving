package takeUForward.hashing;

import java.util.HashMap;
import java.util.Map;

public class P1HighestOccurringElementInAnArray {
    public int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int mostRepeated = 0;
        int freq = 0;
        for ( Map.Entry<Integer, Integer> entry: map.entrySet()){
            if ( entry.getValue() >= freq){
                if ( freq == entry.getValue()){
                    mostRepeated = Math.min( mostRepeated, entry.getKey());
                } else {
                    mostRepeated = entry.getKey();
                    freq = entry.getValue();
                }
            }
        }
        return mostRepeated;
    }
}
