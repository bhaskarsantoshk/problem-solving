package takeUForward.blind75.intervals;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        return maxOverappingMeetingsInOneRoom(intervals) == intervals.length;
    }

    private int maxOverappingMeetingsInOneRoom(int[][] intervals) {
        if ( intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
        int finishTime = intervals[0][1];
        int maxOverLap = 1;
        for ( int i=1; i<intervals.length; i++){
            if ( intervals[i][0] == intervals[i-1][0] && intervals[i][1] == intervals[i-1][1]) return Integer.MAX_VALUE;
            if ( intervals[i][0] >= finishTime){
                maxOverLap++;
                finishTime = intervals[i][1];
            }
        }
        return maxOverLap;
    }
}
