package takeUForward.recursion.revision2;

import java.util.ArrayList;

public class P8CheckIfTheArrayIsSortedII {
    public boolean isSorted(ArrayList<Integer> nums) {
        return isSorted(nums, 1);
    }

    private boolean isSorted(ArrayList<Integer> nums, int i) {
        if ( i == nums.size()) return true;
        if ( nums.get(i) < nums.get(i-1)) return false;
        return isSorted(nums, i+1);
    }
}
