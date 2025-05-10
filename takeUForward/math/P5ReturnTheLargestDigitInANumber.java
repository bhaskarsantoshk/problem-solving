package takeUForward.math;

public class P5ReturnTheLargestDigitInANumber {
    public int largestDigit(int n) {
        int max = 0;
        while ( n > 0){
            max = Math.max( max, n%10);
            n/=10;
        }
        return max;
    }
}
