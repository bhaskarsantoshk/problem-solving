package Recursion;

public class DecimalToBinary {
    public static int convertDecimalToBinary(int n){
        if ( n == 0){
            return 0;
        }
        return (n%2+ 10 *convertDecimalToBinary(n/2));
    }

    // 50
    // 0 25
    // 0 1 12
    // 0 1 0 6
    // 0 1 0 0 3
    // 0 1 0 0 1 1
    // 1 1 0 0 1 0
    // 32+16+2

    // each digit from left is a num % 2 and num gets halved in each iteration.
    // since the position goes left, we will have to multiply with 10
}
