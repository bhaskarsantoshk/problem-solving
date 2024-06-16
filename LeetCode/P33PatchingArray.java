package LeetCode;

public class P33PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patch = 0, index= 0;
        while ( miss <= n){
            if( index < nums.length && nums[index] <= miss){
                miss += nums[index++];
            } else {
                miss += miss;
                patch++;
            }
        }
        return patch;
    }
}
