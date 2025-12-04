package takeUForward.recursion.revision4;

import java.util.Scanner;

public class P5PrintSumOfN {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // parameterized
        f(n, 0);

        // functional
        System.out.println(fFunctional(n));
    }

    private static int fFunctional(int n) {
        if ( n == 0) return 0;
        return n + fFunctional(n-1);
    }

    private static void f(int i, int sum) {
        if ( i < 0) {
            System.out.println(sum);
            return;
        }
        f(i-1, sum+i);
    }
}
