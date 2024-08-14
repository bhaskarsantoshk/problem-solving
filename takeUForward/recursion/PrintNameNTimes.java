package takeuForward.recursion;

import java.util.Scanner;

public class PrintNameNTimes {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        printName(1, n);
    }

    private static void printName(int i, int n) {
        if ( i > n) return;
        System.out.println("Batman");
        printName(i+1, n);
    }
}

// T -> O(N)
// S -> O(N)
