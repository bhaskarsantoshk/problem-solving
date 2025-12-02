package takeUForward.recursion.revision4;

import java.util.Scanner;

public class P2PrintOneToN {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        f(1, n);
    }

    private static void f(int i, int n) {
        if ( i > n) return;
        System.out.println(i);
        f(i+1, n);
    }
    // T : O(N), S : O(N)
}
