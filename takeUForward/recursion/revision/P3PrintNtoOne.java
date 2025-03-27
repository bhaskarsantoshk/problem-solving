package takeUForward.recursion.revision;

import java.util.Scanner;

public class P3PrintNtoOne {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        f(n, n);
    }

    private static void f(int i, int n) {
        if ( i < 1) return;
        System.out.println(i);
        f(i-1, n);
    }
}
