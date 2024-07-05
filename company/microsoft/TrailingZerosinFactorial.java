package company.microsoft;

public class TrailingZerosinFactorial {
    public int trailingZeroes(int A) {
        // prime factorization
        // number of 2s and 5s will add up to trailingZeroes
        // number of 5s are less than number of 2s
        // number of 5s -> A/5
        // there will be 25s that also has an extra number of 5s to the above result ,
        // there will be 125s that also has an extra 5 .. so on
        int fives = 0;
        while ( A != 0 ){
            A = A/5;
            fives += A;
        }
        return fives;
    }
}
