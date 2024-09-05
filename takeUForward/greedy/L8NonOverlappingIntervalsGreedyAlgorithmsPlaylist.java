package takeUForward.greedy;

// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class L8NonOverlappingIntervalsGreedyAlgorithmsPlaylist {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort them  based on end time
        // count maximum non overlapping
        // ans = n- count
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int count = 1;
        int freeTime = intervals[0][1];
        for ( int i=1; i<n; i++){
            if ( intervals[i][0] >= freeTime) {
                count++;
                freeTime = intervals[i][1];
            }
        }
        return n-count;
    }
}
