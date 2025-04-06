package takeUForward.bitManipulation;

public class P17LtoRXOR {
    public static int findXOR(int L, int R){
        return findXOR1toN(L-1) ^ findXOR1toN(R);
    }

    private static int findXOR1toN(int n){
        if ( n % 4 == 1) return 1;
        if ( n % 4 == 2) return n+1;
        if ( n % 4 == 3) return 0;
        if ( n % 4 == 0) return n;
        return 0;
    }
}
