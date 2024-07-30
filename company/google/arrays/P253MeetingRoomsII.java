package company.google.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (interva1, interval2)-> interva1[0]-interval2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int[] interval: intervals){
            if ( pq.isEmpty() ){
                pq.add(interval[1]);
            } else {
                if (!pq.isEmpty() && pq.peek() <= interval[0]){
                    pq.poll();
                }
                pq.offer(interval[1]);
            }
        }
        return pq.size();
    }

    public int minMeetingRoomsApproach2(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        for( int i=0; i<intervals.length; i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0, endPointer=0, rooms = 0;
        while ( startPointer <intervals.length){
            if ( startTimes[startPointer] < endTimes[endPointer]){
                rooms++;
            } else {
                endPointer++;
            }
            startPointer++;
        }
        return rooms;
    }
}

// [[13,15],[1,13],[6,9]]
// 1 13   6 9    13 15
// 13 1

// [[13,15],[1,13]]
// 13
