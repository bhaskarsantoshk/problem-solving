package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (array1, array2) -> Integer.compare(array1[0], array2[0]));
        List<int[]> result = new ArrayList<>();
        int newInterval[] = intervals[0];
        result.add(newInterval);
        for ( int[] interval: intervals ){
            if ( newInterval[1] >= interval[0] ){
                newInterval[1]= Math.max (newInterval[1], interval[1]);
            }
            else{
                newInterval= interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // [[1,3],[2,6],[8,10],[15,18]]
    // { [], [], [].. etc..}
    //
}
