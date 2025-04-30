package takeUForward.recursion.revision2;

public class P6CheckIfANumberIsPrimeOrNot {
    public boolean checkPrime(int num) {
        if ( num <= 1) return false;
        return checkPrime(num, 2);
    }

    private boolean checkPrime(int num, int i) {
        if ( i > (int)Math.sqrt(num)) return true;
        if ( num % i == 0) return false;
        return checkPrime(num, i+1);
    }
}
