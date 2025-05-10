package takeUForward.math;

public class P2CountNumberOfOddDigitsInANumber {
    public int countOddDigit(int n) {
        int countOdd = 0;
        while ( n > 0){
            int rem = n % 10;
            if ( rem % 2== 1 ) countOdd++;
            n /= 10;
        }
        return countOdd;
    }
}
