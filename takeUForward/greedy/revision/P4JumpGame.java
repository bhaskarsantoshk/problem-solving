package takeUForward.greedy.revision;

public class P4JumpGame {
    public boolean canJump(int[] nums) {
        int maxIndexWecanGo = 0;
        for ( int i=0; i<nums.length; i++){
            if ( i > maxIndexWecanGo ) return false;
            maxIndexWecanGo = Math.max(maxIndexWecanGo, i+nums[i]);
        }
        return true;
    }
}
