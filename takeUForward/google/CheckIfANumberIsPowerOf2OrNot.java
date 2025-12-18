package takeUForward.google;

public class CheckIfANumberIsPowerOf2OrNot {
    public boolean isPowerOfTwo(int n) {
        if ( n <= 0) return false;
        return (n & n-1) == 0;
    }
}
