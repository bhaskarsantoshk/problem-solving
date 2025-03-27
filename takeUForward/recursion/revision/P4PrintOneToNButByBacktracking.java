package takeUForward.recursion.revision;

import java.util.Scanner;

public class P4PrintOneToNButByBacktracking {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        f(n);
    }

    private static void f(int n){
        if ( n == 0) return;
        f(n-1);
        System.out.println(n);
    }
}
