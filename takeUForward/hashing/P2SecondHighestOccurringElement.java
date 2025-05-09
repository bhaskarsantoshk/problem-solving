package takeUForward.hashing;

import java.util.HashMap;
import java.util.Map;

public class P2SecondHighestOccurringElement {
    public int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int mostRepeated = Integer.MAX_VALUE;
        int maxFreq = 0;
        int secondMostRepeated = Integer.MAX_VALUE;
        int secondMaxFreq = 0;

        for ( Map.Entry<Integer, Integer> entry: map.entrySet()){
            int value = entry.getKey();
            int freq = entry.getValue();

            if ( freq == maxFreq){
                mostRepeated = Math.min(mostRepeated, value);
            } else if ( freq > maxFreq){
                secondMaxFreq = maxFreq;
                secondMostRepeated = mostRepeated;
                mostRepeated = value;
                maxFreq = freq;
            } else if ( freq == secondMaxFreq){
                secondMostRepeated = Math.min(secondMostRepeated, value);
            } else if ( freq > secondMaxFreq){
                secondMostRepeated = value;
                secondMaxFreq = freq;
            }
        }
        return secondMostRepeated == Integer.MAX_VALUE ? -1: secondMostRepeated;
    }
}

// [4, 4, 5, 5, 6, 7]
// 4 = 2
// 5 = 2
// 6 = 1
