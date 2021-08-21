package company.amazon.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if ( intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (array1, array2)-> Integer.compare(array1[0], array2[0]));
        int[] newInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);
        for ( int[] interval: intervals){
            if (newInterval[1] >= interval[0]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else{
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
