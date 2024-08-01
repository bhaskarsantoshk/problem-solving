package company.google.searching_and_sorting;

import java.util.ArrayList;
import java.util.List;

public class P57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for ( int[] interval: intervals){
            // interval.end < newInterval.start
            if ( newInterval == null || interval[1] < newInterval[0]){
                res.add(interval);
            } else if ( interval[0] > newInterval[1]){
                res.add(interval);
                res.add(newInterval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if ( newInterval != null ){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
