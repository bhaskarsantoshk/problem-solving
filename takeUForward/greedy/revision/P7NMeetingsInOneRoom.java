package takeUForward.greedy.revision;

import java.util.Arrays;
import java.util.Collections;

public class P7NMeetingsInOneRoom {
    public static int maximumMeetings(int []start, int []end) {
        Meeting[] meetings = new Meeting[start.length];
        for ( int i=0; i<meetings.length; i++){
            meetings[i] = new Meeting(start[i], end[i], i);
        }
        Arrays.sort(meetings, (meeting1, meeting2)-> Integer.compare(meeting1.end, meeting2.end));
        int count = 1;
        int freeTime = meetings[0].end;
        for ( int i=1; i<meetings.length; i++){
            if ( meetings[i].start > freeTime){
                count++;
                freeTime = meetings[i].end;
            }
        }
        return count;
    }

    static class Meeting{
        int start;
        int end;
        int pos;

        Meeting(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
}
