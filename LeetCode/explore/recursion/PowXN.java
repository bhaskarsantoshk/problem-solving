package LeetCode.explore.recursion;

public class PowXN {
    public double myPow(double x, int n) {
        int sign = (n>0) ? 1: -1;
        int abs_pow = Math.abs(n);
        double ans = pow (x,abs_pow);
        if (sign == -1){
            return 1/ans;
        }
        return ans;
    }

    private double pow(double x, int abs_pow) {
        if ( abs_pow == 0){
            return 1;
        }
        if (abs_pow == 1){
            return x;
        }
        double temp = pow(x, abs_pow/2);
        if ( abs_pow % 2 == 0){
            return temp * temp;
        }
        return x * temp * temp;
    }
}