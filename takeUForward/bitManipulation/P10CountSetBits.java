package takeUForward.bitManipulation;

public class P10CountSetBits {
    public static int countSetBits(int n) {
        // countSetBits from 1 to N
        long count = 0;
        for ( int i=1; i<=n; i++){
            count = (count + countSetBitsOfSingleNum(i))%1000000007;
        }
        return (int) count%1000000007;
    }

    private static int countSetBitsOfSingleNum(int n) {
        int count =0;
        while ( n> 0){
            n = n&n-1; // we can also check n%2 and increment count & do =n/2;
            count++;
        }
        return count;
    }
}
