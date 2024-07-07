package company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2)-> Integer.compare(a1[0],a2[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int newInterval[] = intervals[0];
        for ( int [] interval : intervals){
            if ( newInterval[1] >= interval[0] ){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
