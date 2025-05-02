package takeUForward.recursion.recursion3;

public class PowXN {
    public double myPow(double x, int exponent) {
        if ( exponent == 0) return 1;
        if ( exponent == 1) return x;
        if ( exponent < 0) {
            x = 1/x;
            exponent = Math.abs(exponent);
        }
        return x * myPow(x, exponent-1);
    }

    public double myPowRecOptimized(double x, int exponent) {
        if ( exponent == 0) return 1;
        if ( exponent == 1) return x;
        if ( exponent < 0) {
            x = 1/x;
            exponent = Math.abs(exponent);
        }
        if ( exponent % 2 == 0){
            return myPowRecOptimized(x*x, exponent/2);
        } else {
            return x * myPowIterative(x, exponent-1);
        }
    }

    public double myPowIterative(double x, int exponent) {
        double answer = 1;
        if ( exponent == 0) return 1;
        if ( exponent == 1) return x;
        if ( exponent < 0) {
            x = 1/x;
            exponent = Math.abs(exponent);
        }
        while ( exponent > 0){
            if ( exponent % 2 == 0){
                x = x*x;
                exponent /=2;
            } else {
                answer = x * answer;
                exponent--;
            }
        }
        return answer;
    }
}

