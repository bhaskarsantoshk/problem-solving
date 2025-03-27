package takeUForward.recursion.revision;

import java.util.Scanner;

public class P1PrintNameNTimesUsingRecursion {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Printing Name " + n+ " times");
        f(1, n);
    }

    private static void f(int i, int n) {
        if ( i > n) return;
        System.out.println("Batman");
        f(i+1, n);
    }
    // T : O(N), S : O(N)
}
