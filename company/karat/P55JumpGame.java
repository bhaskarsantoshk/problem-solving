package company.karat;

public class P55JumpGame {
    // Observations:
    // 1. if we don't have 0, we can always reach last index
    // 2. whenever we traverse to an index, ask did anyone reach you ? How, by keeping te max index we can reach.
    public boolean canJump(int[] nums) {
        int maxIndexWeCanReach = 0;
        for ( int i=0; i<nums.length; i++){
            if ( i > maxIndexWeCanReach) return false;
            maxIndexWeCanReach = Math.max(maxIndexWeCanReach, i+nums[i]);
        }
        return true;
    }
}
