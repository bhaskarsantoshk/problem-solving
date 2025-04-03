package CSES;

import java.util.Scanner;

public class P4IncreasingArray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for ( int i=0; i<n; i++) a[i] = in.nextInt();
        long count = 0;
        for ( int i=1; i<n; i++){
            if ( a[i] > a[i-1]) continue;
            count+= a[i-1]-a[i];
            a[i] = a[i-1];
        }
        System.out.println(count);
    }
}

/*
 * CSES SUBMISSION GUIDELINES (for Java):
 *
 * DO:
 *   - Use a single class with *no* access modifier (i.e., not public).
 *   - Name the class anything (e.g., Main, Solver, etc.).
 *
 * DON'T:
 *   - Don't use 'package' statements — CSES won't compile files with them.
 *   - Don't declare your class as 'public' — you'll get a compilation error like:
 *       "class X is public, should be declared in a file named X.java"
 *
 * Summary:
 *   Remove the 'package' line and the 'public' keyword from your class before submission.
 */
