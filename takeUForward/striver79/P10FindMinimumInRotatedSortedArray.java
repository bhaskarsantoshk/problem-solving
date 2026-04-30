package takeUForward.striver79;

import java.util.ArrayList;

public class P10FindMinimumInRotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for ( int num: arr) min = Math.min(min, num);
        return min;
    }
}
