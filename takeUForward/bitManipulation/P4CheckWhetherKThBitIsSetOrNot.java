package takeUForward.bitManipulation;

public class P4CheckWhetherKThBitIsSetOrNot {
    static boolean isKthBitSet(int n, int k) {
        int mask = (1 << (k-1));
        return (n&mask) !=0;
    }
}
