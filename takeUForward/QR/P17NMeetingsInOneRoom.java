package takeUForward.QR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class P17NMeetingsInOneRoom {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        Meet[] meetings = new Meet[n];
        for ( int i=0; i<n; i++) meetings[i] = new Meet(start[i], end[i], i+1);

        Arrays.sort(meetings, ((o1, o2) -> o1.end-o2.end));

        int count = 1;
        List<Meet> result = new ArrayList<>();
        result.add(meetings[0]);
        int freeTime = meetings[0].end;

        for ( int i=1; i<n; i++){
            if ( meetings[i].start > freeTime ){
                count++;
                freeTime = meetings[i].end;
                result.add(meetings[i]);
            }
        }
        return count;
    }

    class Meet{
        int start;
        int end;
        int position;

        Meet(int start, int end, int position){
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }
}
