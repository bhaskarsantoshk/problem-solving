package takeUForward.recursion.revision4;

import java.util.Scanner;

public class P6FactorialOfN {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // parameterized
        f(n, 1);

        // functional
        System.out.println(fFunctional(n));
    }

    private static int fFunctional(int n) {
        if ( n == 1) return 1;
        return n * fFunctional(n-1);
    }

    private static void f(int i, int fact) {
        if ( i == 1) {
            System.out.println(fact);
            return;
        }
        f(i-1, fact*i);
    }
}
