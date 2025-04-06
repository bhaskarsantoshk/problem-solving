package takeUForward.bitManipulation;

public class P16XORofNumbersInGivenRange {
    public static int calculateXOR(int n) {
        if ( n % 4 == 1) return 1;
        if ( n % 4 == 2) return n+1;
        if ( n % 4 == 3) return 0;
        if ( n % 4 == 0) return n;
        return 0;
    }
}
