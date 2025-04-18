package takeUForward.arrays;

public class P8MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for ( int num: nums){
            if (num == 0){
                count = 0;
            } else{
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    // 1 1 1 1
    // 0 1 0 1
    // 0 0 0 0
    // 0 0 0 0 1 1 1 0 0 1 1 1 1 1
}
