package takeUForward.blind75.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));
        pq.add(intervals[0]);
        for ( int i=1; i<intervals.length; i++){
            int [] prevMeeting = pq.peek();
            if ( intervals[i][0] >= prevMeeting[1]){
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}
