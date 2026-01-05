package takeUForward.recursion.revision4;

public class P13CheckIfANumberIsPrimeOrNot {
    public boolean checkPrime(int num) {
        if ( num <= 1) return false;
        return checkPrime(num, 2);
    }

    private boolean checkPrime(int num, int i) {
        if ( i * i >= num) return true;
        if ( num % i == 0) return false;
        return checkPrime(num, i+1);
    }
}
