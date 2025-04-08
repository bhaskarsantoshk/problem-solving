package takeUForward.greedy.revision;

import java.util.ArrayList;
import java.util.List;

public class P9InsertInterval {
    public static int[][] addInterval(int[][] intervals, int n, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i=0;
        // left
        while ( i <n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        // mid
        while ( i < n && intervals[i][1] <= newInterval[1]){
            newInterval[0] = Math.min( intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);

        // right
        while ( i < n ){
            list.add(intervals[i]);
            i++;
        }

        int[][] res = new int[list.size()][2];
        for ( int index=0; index<list.size(); index++){
            res[index][0] = list.get(index)[0];
            res[index][1] = list.get(index)[1];
        }
        return res;
    }
}
