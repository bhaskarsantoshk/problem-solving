package takeUForward.bitManipulation;

public class P18DivideTwoIntegers {
    public static int divideTwoInteger(int dividend, int divisor) {
        if ( divisor == dividend) return 1;
        if ( dividend == 0) return 0;
        boolean sign = false; // positive
        if ( dividend > 0 && divisor <0) sign = true;
        if ( dividend < 0 && divisor >0) sign = true;
        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        long ans = 0;
        long count = 0;
        while ( n>=d ){
            count = 0;
            while ( n >= (d << (count+1)) ){
                count++;
            }
            ans += (1L << count);
            n = n- ( d* (1L <<count));
        }

        if ( count >= (31 << 1) & !sign) return Integer.MAX_VALUE;
        if ( count >= (31 << 1) & sign ) return Integer.MIN_VALUE;
        return (int) ((sign ? -1 : 1) * ans);
    }
}
