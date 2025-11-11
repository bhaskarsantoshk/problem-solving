package takeUForward.QR;

public class P15SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for ( int num: nums) xor ^= num;
        int rightMost = (int)(xor & (xor-1)) ^ (int)xor;
        int first = 0;
        int second = 0;
        for ( int num: nums){
            if ( (num & rightMost) != 0 ) first ^= num;
            else second ^= num;
        }
        if ( first > second )return new int[]{second, first};
        return new int[]{first, second};
    }
}
