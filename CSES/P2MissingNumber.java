package CSES;

import java.util.Scanner;

public class P2MissingNumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n-1];
        for ( int i=0; i<n-1; i++){
            a[i] = in.nextInt();
        }
        System.out.println(findMissingNumber(a, n));
    }

    private static int findMissingNumber(int[] a, int n) {
        int xor = 0;
        for ( int num: a){
            xor ^= num;
        }
        for ( int i=1; i<=n; i++){
            xor ^= i;
        }
        return xor;
    }
}

// CSES SUBMISSION NOTE:
// - Do NOT include the 'package' statement when submitting to CSES.
// - The class should NOT be public. CSES runs your code in a specific environment
//   where your class must be default (no access modifier) and cannot belong to any package.
//
// If you submit with `package CSES;` or `public class P2MissingNumber`,
// you'll get a compilation error like:
// ➤ "error: class P2MissingNumber is public, should be declared in a file named P2MissingNumber.java"
// or simply "Compilation error" without details.
//
// To fix this, remove the `package` line and make the class non-public before submission.
