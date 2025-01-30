package takeUForward.binarySearch;

// https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557?leftPanelTabValue=PROBLEM

import java.util.ArrayList;

public class PainterSPartitionProblem {
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = 0, high = 0;
        for ( Integer num: boards){
            low = Math.max( low, num);
            high += num;
        }

        int ans = -1;

        while ( low <= high ){
            int mid = low + (high-low)/2;
            if ( computePainters(boards, mid) <= k){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    private static int computePainters(ArrayList<Integer> board, int maxSize ){
        int painters = 1;
        int size = 0;
        for ( int i=0; i<board.size(); i++){
            if ( size + board.get(i) <= maxSize){
                size+= board.get(i);
            } else {
                size = board.get(i);
                painters++;
            }
        }
        return painters;
    }
}
