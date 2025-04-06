package takeUForward.bitManipulation;

import java.util.Arrays;

public class P15SingleNumberIII {
    public static void twoNonRepeatingElements(int arr[], int n) {
        long xor = 0;
        for ( int num: arr){
            xor ^= num;
        }
        long rightMost = (xor&(xor-1)) ^ (xor);
        int ans[]  = new int[2];
        for ( int num: arr){
            if ( (num & rightMost) != 0) ans[0] ^= num;
            else ans[1] ^= num;
        }
        Arrays.sort(ans);
    }
}
