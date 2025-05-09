package takeUForward.math;

import java.util.HashMap;
import java.util.Map;

public class P4SumOfHighestAndLowestFrequency {
    public int sumHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, min= Integer.MAX_VALUE;
        for ( int num: nums){
            map.put(num ,map.getOrDefault(num,0)+1);
        }
        for ( Map.Entry<Integer, Integer> entry: map.entrySet()){
            max = Math.max( max, entry.getValue());
            min = Math.min( min, entry.getValue());
        }
        return max+min;
    }
}
