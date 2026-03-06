package company.apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40MergeOverlappingIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(prev);

        for ( int[] interval: intervals){
            if ( interval[0] > prev[1]){
                list.add(interval);
                prev = interval;
            } else {
                prev[0] = Math.min(prev[0], interval[0]);
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i=0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
