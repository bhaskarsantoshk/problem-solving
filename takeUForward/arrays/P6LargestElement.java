package takeUForward.arrays;

public class P6LargestElement {
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for ( int num: nums) max = Math.max(max, num);
        return max;
    }
}
