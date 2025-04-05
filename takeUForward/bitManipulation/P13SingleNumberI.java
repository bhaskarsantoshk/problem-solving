package takeUForward.bitManipulation;

public class P13SingleNumberI {
    public static int occursOnce(int[] a, int n) {
        int xor = 0;
        for ( int num: a) xor ^= num;
        return xor;
    }

    // xor of odd number of 1s = 1
    // xor of even number of 1s = 0
}
