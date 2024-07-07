package company.microsoft.bit_manipulation;

public class DivideIntegers {
    public int divide(int A, int B) {
        // Edge cases
        // b == 0 -> ans = INT_MAX;
        // a == 0 -> ans = 0;
        // overflow condition -> a = INT_MIN ( -2147483648 ) and b = -1 -> ans = INT_MAX
        if ( B == 0) return Integer.MAX_VALUE;
        if ( A == 0 ) return 0;
        if ( A == Integer.MAX_VALUE && B == -1 ) return Integer.MAX_VALUE;
        boolean neagative = ( A < 0) != (B < 0);
        // TODO
        return 0;
    }
}
