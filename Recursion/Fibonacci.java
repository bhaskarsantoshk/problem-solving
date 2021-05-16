package Recursion;

public class Fibonacci {
    public static int fibonacci(int n){
        if ( n <= 1){
            return n;
        }
        return fibonacci(n-1)+ fibonacci(n-2);
    }

    public static void main( String args[] ) {
        int input = 5;
        int i = 0;
        while (i < input) {
            System.out.print(fibonacci(i) + " ");
            i++;
        }
    }
}
