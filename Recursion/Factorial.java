package Recursion;

public class Factorial {
    private static int factorial(int n){
        if ( n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }


    private static int factorialIterative ( int n){
        int res = 1;
        for ( int i=1; i<= n; i++){
            res *= i;
        }
        return res;
    }
}
