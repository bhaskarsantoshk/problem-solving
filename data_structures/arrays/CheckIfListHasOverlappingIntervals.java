package data_structures.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class CheckIfListHasOverlappingIntervals {
    public static boolean checkIfIntervalsOverlap ( int[][] intervals ){
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        for ( int i=1; i<intervals.length-1; i++){
            if ( intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] a={{1,4}, {2,4},{7,9}};
        System.out.println(checkIfIntervalsOverlap(a));
        int[][] b = {{6,7}, {2,4},{8,12}};
        System.out.println(checkIfIntervalsOverlap(b));
    }
}
