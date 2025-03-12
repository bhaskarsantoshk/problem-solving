package takeUForward.blind75.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // [[1,3],[2,6],[8,10],[15,18]]
    //

    public int[][] merge(int[][] intervals) {
        if ( intervals == null || intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] prevInterval = intervals[0];
        res.add(prevInterval);
        for(int[] interval: intervals){
            if ( interval[0] > prevInterval[1]){
                res.add(interval);
                prevInterval = interval;
            } else {
                prevInterval[0] = Math.min(prevInterval[0], interval[0]);
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
