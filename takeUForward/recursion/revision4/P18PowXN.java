package takeUForward.recursion.revision4;

public class P18PowXN {
    public double myPowBruteForce(double x, int n) {
       double ans = 1;
       if ( n < 0){
           x = 1/x;
           n = -1*n;
       }

       for ( int i=1; i<=n; i++) ans = ans * x;
       return ans;
    }

    class Solution {
        public double myPow(double x, int n) {

            // If n == Integer.MIN_VALUE (-2147483648),
            // then -n overflows and remains negative.
            // This causes infinite recursion and stack overflow.
            if (n < 0) {
                x = 1 / x;
                n = -1 * n;   // overflow bug
            }

            if (n == 1) return x;
            if (n == 0) return 1;

            double ans = myPow(x, n / 2);

            if (n % 2 == 0) {
                return ans * ans;
            }

            return ans * ans * x;
        }
    }
}
