package company.google.arrays;

public class P55JumpGame {
    public boolean canJump(int[] nums) {

        // empty array or 0 length array or 1 element array
        if ( nums == null || nums.length <= 1) return true;

        int maxSoFar = 1;
        for ( int i=0; i<nums.length; i++){
            // assume you already made one jump when you reach next index
            maxSoFar--;
            // from index i, max that you can jump
            maxSoFar = Math.max(maxSoFar, nums[i]);

            if ( maxSoFar == 0 && i != nums.length-1) return false;
        }
        return true;
    }
}
