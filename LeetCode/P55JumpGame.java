package LeetCode;

public class P55JumpGame {
    public boolean canJump(int[] nums) {
        // max you can reach from i
        int max = 0 ; //initially 0;
        for ( int i=0; i< nums.length; i++){
            if ( max < i){
                return false;
            }
            max = ( i+ nums[i]) > max ? i+ nums[i] : max;
        }
        return true;
    }
}
