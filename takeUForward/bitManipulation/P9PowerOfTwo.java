package takeUForward.bitManipulation;

public class P9PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return (n&(n-1))==0;
    }
}
