package takeUForward.blind75.intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        // n - maxOverlapping
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));
        int finishTime = intervals[0][1];
        int overlapCount = 1;
        for ( int i=1; i<intervals.length; i++){
            if ( intervals[i][0] >= finishTime){
                finishTime = intervals[i][1];
                overlapCount++;
            }
        }
        return intervals.length - overlapCount;
    }
}
