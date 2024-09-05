package takeUForward.greedy;

import java.util.Arrays;

public class L7NMeetingInOneRoomGreedyAlgorithmsPlaylist {
    public int maxMeetings(int n, int start[], int end[]) {
        int[][] meeting = new int[n][3];
        for( int i=0; i<n; i++){
            meeting[i][0] = i+1;
            meeting[i][1] = start[i];
            meeting[i][2] = end[i];
        }

        Arrays.sort(meeting, (a, b)-> a[2]-b[2]);
        int count = 1;
        int freeTime = meeting[0][2];

        for ( int i=1; i<n; i++){
            if ( meeting[i][1] > freeTime){
                count++;
                freeTime = meeting[i][2];
            }
        }
        return count;
    }
}
