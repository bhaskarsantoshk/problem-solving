package striver_sde_sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if ( intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);
        for ( int[] interval : intervals){
            // ( 1, 8) ( 2, 10)
            if ( interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                // ( 1, 10 ), ( 15 , 20)
                res.add(interval);
                newInterval = interval;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
