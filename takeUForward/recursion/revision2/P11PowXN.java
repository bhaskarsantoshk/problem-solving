package takeUForward.recursion.revision2;

public class P11PowXN {
    public double myPow(double x, int exponent) {
        if ( exponent == 0) return 1;
        if ( exponent < 0) x = 1/x;
        exponent = Math.abs(exponent);
        return x * myPow(x, exponent-1);
    }

    public double myPowRecOptimized(double x, int exponent) {
        if ( exponent == 0) return 1;
        if ( exponent < 0) x = 1/x;
        exponent = Math.abs(exponent);
        return (exponent % 2 == 0) ? myPow(x*x, exponent/2): x * myPow(x, exponent-1);
    }

    public double myPowIterative(double x, int exponent) {
        if ( exponent == 0) return 1;
        if ( exponent < 0) x = 1/x;
        double ans = 1;
        exponent = Math.abs(exponent);
        while ( exponent > 0) {
            if (x % 2 == 0) {
                x = x * x;
                exponent /= 2;
            } else {
                ans = ans * x;
                exponent--;
            }
        }
        return ans;
    }
}

