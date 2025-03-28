package takeUForward.recursion.revision;

import java.util.Scanner;

public class P9Fibonacci {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if ( n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }
    // T: O(2^N) S:O(N)
}
