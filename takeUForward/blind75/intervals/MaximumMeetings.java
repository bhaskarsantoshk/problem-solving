package takeUForward.blind75.intervals;

import java.util.ArrayList;
import java.util.List;

public class MaximumMeetings {
    public static int maximumMeetings(int []start, int []end) {
        List<Meeting> list = new ArrayList<>();
        for ( int i=0; i<start.length; i++){
            list.add(new Meeting(start[i], end[i], i));
        }
        list.sort((meeting1, meeting2)-> Integer.compare(meeting1.end,meeting2.end));
        int overlap =1 ;
        int finishTime = list.get(0).end;
        for ( int i=1 ; i<list.size(); i++){
            if ( list.get(i).start > finishTime) {
                overlap++;
                finishTime = list.get(i).end;
            }
        }
        return overlap;
    }

    static class Meeting{
        int start, end, pos;

        public Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
}
