package takeUForward.recursion.revision4;

import java.util.ArrayList;

public class P15CheckIfTheArrayIsSortedII {
    public boolean isSorted(ArrayList<Integer> nums) {
        return isSorted(nums, 0);
    }

    private boolean isSorted(ArrayList<Integer> nums, int index) {
        if ( index >= nums.size()-1) return true;
        if ( nums.get(index) > nums.get(index+1)) return false;
        return isSorted(nums, index+1);
    }
}
