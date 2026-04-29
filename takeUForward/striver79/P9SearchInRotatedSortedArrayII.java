package takeUForward.striver79;

public class P9SearchInRotatedSortedArrayII {
    public boolean searchInARotatedSortedArrayIIBruteForce(int[] nums, int k) {
        for ( int num: nums) if ( num == k) return true;
        return false;
    }
}
