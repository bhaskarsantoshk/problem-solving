package data_structures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    class Pair{
        private int start,end;
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static ArrayList<Pair> mergeIntervals(ArrayList<Pair> intervals){
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
        ArrayList<Pair> result = new ArrayList<>();
        Pair newInterval = intervals.get(0);
        result.add(newInterval);

        for ( Pair interval: intervals){
            if ( newInterval.end >= interval.start){
                newInterval.end = Math.max (newInterval.end, interval.end);
            }
            else {
                newInterval = interval;
            }
        }
        return result;
    }
}
