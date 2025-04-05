package takeUForward.bitManipulation;

public class P5SetIthBit {
    static int setKthBit(int n, int k) {
        int mask = (1 << (k-1));
        return n | mask;
    }
}
